package hr.josip.composeapp.ui.feed

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.viewModelScope
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
        delay(1000)
        viewState =
            FeedState(feedModel = withContext(Dispatchers.IO) { getFeedUseCase.execute(Unit) })
        showIdle()
    }

    @Synchronized
    fun markStoryAsRead(storyModel: StoryModel) = viewModelScope.launch {
        viewState?.feedModel?.apply {
            viewState = viewState?.copy(
                feedModel = updateStoryState(storyModel, StoryState.LOADING)?.let {
                    viewState?.feedModel?.copy(
                        postModels = postModels,
                        storyModels = it
                    )
                }
            )
            delay(1000)
            viewState = viewState?.copy(
                feedModel = updateStoryState(storyModel, StoryState.READ)?.let {
                    viewState?.feedModel?.copy(
                        postModels = postModels,
                        storyModels = it
                    )
                }
            )
        }
    }

    private suspend fun updateStoryState(storyModel: StoryModel, newState: StoryState) =
        withContext(Dispatchers.IO) {
            viewState?.feedModel?.storyModels?.map {
                if (it.id == storyModel.id) {
                    it.copy(id = storyModel.id, user = storyModel.user, storyState = newState)
                } else it
            }
        }

    fun updateStatus(status: String) = viewModelScope.launch {
        viewState?.feedModel?.apply {
            val updatedPosts = postModels.toMutableList().apply {
                add(
                    0, PostModel(
                        id = 10,
                        user = userManager.getCurrentActiveUser(),
                        text = status,
                        date = Date()
                    )
                )
            }
            viewState = viewState?.copy(
                feedModel = viewState?.feedModel?.copy(
                    postModels = updatedPosts,
                    storyModels = storyModels
                )
            )
        }
    }
}

