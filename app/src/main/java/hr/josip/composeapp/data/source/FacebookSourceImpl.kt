package hr.josip.composeapp.data.source

import hr.josip.composeapp.data.common.Mock
import hr.josip.composeapp.data.model.feed.response.FeedModel
import hr.josip.composeapp.shared.manager.user.UserManager
import javax.inject.Inject

class FacebookSourceImpl @Inject constructor(private val userManager: UserManager) :
    FacebookSource {

    override suspend fun getFeed(): FeedModel =
        FeedModel(storyModels = Mock.getStories(userManager), postModels = Mock.getPosts())
}