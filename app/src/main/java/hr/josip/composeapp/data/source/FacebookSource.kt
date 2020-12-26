package hr.josip.composeapp.data.source

import hr.josip.composeapp.data.model.feed.response.Feed

interface FacebookSource {
    suspend fun getFeed(): Feed
}