package hr.josip.composeapp.ui.feed

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.viewModelScope
import hr.josip.composeapp.data.model.feed.response.Post
import hr.josip.composeapp.data.model.feed.response.Story
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
            FeedState(feed = withContext(Dispatchers.IO) { getFeedUseCase.execute(Unit) })
        showIdle()
    }

    fun markStoryAsRead(story: Story) = viewModelScope.launch {
        viewState?.feed?.apply {
            viewState = viewState?.copy(
                feed = updatestoriestate(story, StoryState.LOADING)?.let {
                    viewState?.feed?.copy(
                        posts = posts,
                        stories = it
                    )
                }
            )
            delay(1000)
            viewState = viewState?.copy(
                feed = updatestoriestate(story, StoryState.READ)?.let {
                    viewState?.feed?.copy(
                        posts = posts,
                        stories = it
                    )
                }
            )
        }
    }

    private suspend fun updatestoriestate(story: Story, newState: StoryState) =
        withContext(Dispatchers.IO) {
            viewState?.feed?.stories?.map {
                if (it.id == story.id) {
                    it.copy(id = story.id, user = story.user, storiestate = newState)
                } else it
            }
        }

    fun updateStatus(status: String) = viewModelScope.launch {
        viewState?.feed?.apply {
            val updatedPosts = posts.toMutableList().apply {
                add(
                    0, Post(
                        id = 10,
                        user = userManager.getCurrentActiveUser(),
                        text = status,
                        date = Date()
                    )
                )
            }
            viewState = viewState?.copy(
                feed = viewState?.feed?.copy(
                    posts = updatedPosts,
                    stories = stories
                )
            )
        }
    }
}

