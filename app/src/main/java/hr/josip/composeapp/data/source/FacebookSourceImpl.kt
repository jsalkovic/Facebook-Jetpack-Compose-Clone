package hr.josip.composeapp.data.source

import hr.josip.composeapp.data.common.Mock
import hr.josip.composeapp.data.common.User
import hr.josip.composeapp.data.model.feed.response.Feed
import hr.josip.composeapp.data.model.feed.response.Story
import javax.inject.Inject

class FacebookSourceImpl @Inject constructor() : FacebookSource {

    override suspend fun getFeed(): Feed = Feed(stories = Mock.getStories())
}