package hr.josip.composeapp.ui.feed

import hr.josip.composeapp.data.model.feed.response.Feed

data class FeedState (val feed: Feed? = null)

class FeedEvent