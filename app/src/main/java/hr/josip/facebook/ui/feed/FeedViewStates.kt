package hr.josip.facebook.ui.feed

import hr.josip.facebook.data.model.feed.response.Feed
import hr.josip.facebook.data.model.feed.response.Story

data class FeedState (val feed: Feed? = null)

sealed class FeedEvent {
    class StoryLoaded(story: Story) : FeedEvent()
}