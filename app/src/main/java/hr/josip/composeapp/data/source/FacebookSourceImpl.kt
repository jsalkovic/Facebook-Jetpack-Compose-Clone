package hr.josip.composeapp.data.source

import hr.josip.composeapp.data.model.feed.response.FeedModel
import javax.inject.Inject

class FacebookSourceImpl @Inject constructor() : FacebookSource {

    override suspend fun getFeed(): FeedModel = FeedModel()
}