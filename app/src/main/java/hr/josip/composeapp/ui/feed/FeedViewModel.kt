package hr.josip.composeapp.ui.feed

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.viewModelScope
import hr.josip.composeapp.data.common.Mock
import hr.josip.composeapp.data.model.feed.response.FeedModel
import hr.josip.composeapp.data.model.feed.response.PostModel
import hr.josip.composeapp.data.model.feed.response.StoryModel
import hr.josip.composeapp.data.model.feed.response.StoryState
import hr.josip.composeapp.domain.UseCases
import hr.josip.composeapp.shared.manager.user.UserManager
import hr.josip.composeapp.ui.shared.base.BaseViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.*

class FeedViewModel @ViewModelInject constructor(
    private val userManager: UserManager,
    private val getFeedUseCase: UseCases.GetFeedUseCase
) :
    BaseViewModel<FeedState, FeedEvent>() {

    fun init() {
        if (viewState == null) getFeed()
    }

    private fun getFeed() = viewModelScope.launch {
        showLoading()
        delay(1500)
        viewState =
            FeedState(feedModel = withContext(Dispatchers.IO) { getFeedUseCase.execute(Unit) })
        showIdle()
    }

    fun markStoryAsRead(storyModel: StoryModel) = viewModelScope.launch {
        updateStoryState(storyModel, StoryState.LOADING)?.let { storyLoading ->
            viewState =
                viewState?.copy(feedModel = FeedModel(storyModels = storyLoading))
            delay(2000)
            updateStoryState(storyModel, StoryState.READ)?.let { storyRead ->
                viewState =
                    viewState?.copy(feedModel = FeedModel(storyModels = storyRead))
            }
        }
    }

    private suspend fun updateStoryState(storyModel: StoryModel, newState: StoryState) =
        withContext(Dispatchers.IO) {
            viewState?.feedModel?.storyModels?.map {
                if (it.id == storyModel.id)
                    it.storyState = newState
                it
            }
        }

    fun updateStatus(status: String) = viewModelScope.launch {
        viewState?.feedModel?.postModels?.toMutableList()?.apply {
            add(
                0,
                PostModel(
                    id = 10,
                    user = userManager.getCurrentActiveUser(),
                    text = status,
                    date = Date()
                )
            )
            viewState = viewState?.copy(
                feedModel = FeedModel(
                    postModels = this,
                    storyModels = Mock.getStories(userManager)
                )
            )
        }
    }
}

