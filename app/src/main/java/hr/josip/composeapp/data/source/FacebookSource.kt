package hr.josip.composeapp.data.source

import hr.josip.composeapp.data.model.feed.response.FeedModel

interface FacebookSource {
    suspend fun getFeed(): FeedModel
}