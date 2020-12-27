package hr.josip.facebook.data.source

import hr.josip.facebook.data.model.feed.response.Feed

interface FacebookSource {
    suspend fun getFeed(): Feed
}