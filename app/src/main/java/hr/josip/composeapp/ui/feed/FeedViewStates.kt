package hr.josip.composeapp.ui.feed

import hr.josip.composeapp.data.model.feed.response.FeedModel

data class FeedState (val feedModel: FeedModel? = null)

class FeedEvent