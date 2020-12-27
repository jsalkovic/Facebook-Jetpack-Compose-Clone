package hr.josip.composeapp.ui.feed

import hr.josip.composeapp.data.model.feed.response.Feed
import hr.josip.composeapp.data.model.feed.response.Story

data class FeedState (val feed: Feed? = null)

sealed class FeedEvent {
    class StoryLoaded(story: Story) : FeedEvent()
}