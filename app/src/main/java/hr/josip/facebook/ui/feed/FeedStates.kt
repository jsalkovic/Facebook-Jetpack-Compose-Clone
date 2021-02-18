package hr.josip.facebook.ui.feed

import hr.josip.facebook.data.model.feed.response.Feed
import hr.josip.facebook.data.model.feed.response.Post
import hr.josip.facebook.data.model.feed.response.Story

data class FeedState(val feed: Feed? = null)

sealed class FeedEvent {
    object GetFeed : FeedEvent()
    class UpdateStatus(val status: String) : FeedEvent()
    class ShowPostDetails(val post: Post) : FeedEvent()
    class LikeClicked(val post: Post) : FeedEvent()
    class AddComment(val post: Post, val comment: String) : FeedEvent()
    class SharPost(val post: Post) : FeedEvent()
    class MarkStoryAsRead(val story: Story) : FeedEvent()
    class ShowStoryContent(val story: Story) : FeedEvent()
    object AddNewUserStory : FeedEvent()
}

sealed class FeedEffect {
    object AddNewStoryUnavailable : FeedEffect()
    class SharePostUnavailable(val post: Post) : FeedEffect()
    class ShowPostDetailsUnavailable(val post : Post) : FeedEffect()
    class ShowStoryContentUnavailable(val story : Story) : FeedEffect()
}