package hr.josip.facebook.ui.feed

import android.util.Log
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import hr.josip.facebook.data.model.feed.response.Comment
import hr.josip.facebook.data.model.feed.response.Post
import hr.josip.facebook.data.model.feed.response.Story
import hr.josip.facebook.data.model.feed.response.StoryState
import hr.josip.facebook.domain.UseCases
import hr.josip.facebook.shared.manager.user.UserManager
import hr.josip.facebook.ui.shared.base.BaseViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.*
import javax.inject.Inject
import kotlin.random.Random

@HiltViewModel
class FeedViewModel @Inject constructor(
    private val userManager: UserManager,
    private val getFeedUseCase: UseCases.GetFeedUseCase
) : BaseViewModel<FeedState, FeedEvent, FeedEffect>() {

    override fun handleIntent(event: FeedEvent) {
        when (event) {
            FeedEvent.GetFeed -> getFeed()
            is FeedEvent.AddComment -> addComment(event.post, event.comment)
            FeedEvent.AddNewUserStory -> addNewUserStory()
            is FeedEvent.LikeClicked -> onLikeClicked(event.post)
            is FeedEvent.MarkStoryAsRead -> markStoryAsRead(event.story)
            is FeedEvent.SharPost -> sharePost(event.post)
            is FeedEvent.ShowPostDetails -> showPostDetails(event.post)
            is FeedEvent.ShowStoryContent -> showStoryContent(event.story)
            is FeedEvent.UpdateStatus -> updateStatus(event.status)
        }
    }

    private fun getFeed() = viewModelScope.launch {
        if (viewState?.feed == null) {
            showLoading()
            delay(1000)
            viewState =
                FeedState(feed = withContext(Dispatchers.IO) { getFeedUseCase.execute(Unit) })
            clearCommonState()
        }
    }

    private fun markStoryAsRead(story: Story) = viewModelScope.launch {
        viewState?.feed?.apply {
            viewState = viewState?.copy(
                feed = updateStoryState(story, StoryState.LOADING)?.let {
                    viewState?.feed?.copy(
                        posts = posts,
                        stories = it
                    )
                }
            )
            delay(1000)
            viewState = viewState?.copy(
                feed = updateStoryState(story, StoryState.READ)?.let {
                    viewState?.feed?.copy(
                        posts = posts,
                        stories = it
                    )
                }
            )
            showStoryContent(story)
        }
    }

    private suspend fun updateStoryState(story: Story, newState: StoryState) =
        withContext(Dispatchers.IO) {
            viewState?.feed?.stories?.map {
                if (it.id == story.id) {
                    it.copy(id = story.id, user = story.user, storyState = newState)
                } else {
                    it
                }
            }
        }

    private fun updateStatus(status: String) = viewModelScope.launch {
        viewState?.feed?.apply {
            val updatedPosts = posts.toMutableList().apply {
                add(
                    0,
                    Post(
                        id = Random.nextInt(100),
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

    private fun onLikeClicked(post: Post) = viewModelScope.launch {
        viewState?.feed?.apply {
            val updatedPosts = viewState?.feed?.posts?.map {
                if (it.id == post.id) {
                    if (it.isLikedByCurrentUser.not()) {
                        it.copy(isLikedByCurrentUser = true, likes = post.likes + 1)
                    } else {
                        it.copy(isLikedByCurrentUser = false, likes = post.likes - 1)
                    }
                } else {
                    it
                }
            }
            updatedPosts?.let {
                viewState = viewState?.copy(
                    feed = viewState?.feed?.copy(
                        posts = it,
                        stories = stories
                    )
                )
            }
        }
    }

    private fun addComment(post: Post, comment: String) = viewModelScope.launch {
        viewState?.feed?.apply {
            val updatedPosts = viewState?.feed?.posts?.map {
                val updatedComments = it.comments.toMutableList()
                if (it.id == post.id) {
                    updatedComments.add(
                        Comment(
                            id = Random.nextInt(100),
                            text = comment,
                            date = Date(),
                            user = userManager.getCurrentActiveUser()
                        )
                    )
                }
                it.copy(comments = updatedComments)
            }
            updatedPosts?.let {
                viewState = viewState?.copy(
                    feed = viewState?.feed?.copy(
                        posts = it,
                        stories = stories
                    )
                )
            }
        }
    }

    private fun addNewUserStory() = emitEffect(FeedEffect.AddNewStoryUnavailable)

    private fun sharePost(post: Post) = emitEffect(FeedEffect.SharePostUnavailable(post))

    private fun showPostDetails(post: Post) =
        emitEffect(FeedEffect.ShowPostDetailsUnavailable(post))

    private fun showStoryContent(story: Story) =
        emitEffect(FeedEffect.ShowStoryContentUnavailable(story))
}

