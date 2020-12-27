package hr.josip.facebook.data.source

import hr.josip.facebook.data.common.Mock
import hr.josip.facebook.data.model.feed.response.Feed
import hr.josip.facebook.shared.manager.user.UserManager
import javax.inject.Inject

class FacebookSourceImpl @Inject constructor(private val userManager: UserManager) :
    FacebookSource {

    override suspend fun getFeed(): Feed =
        Feed(stories = Mock.getStories(userManager), posts = Mock.getPosts())
}