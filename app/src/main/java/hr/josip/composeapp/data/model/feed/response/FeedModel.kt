package hr.josip.composeapp.data.model.feed.response

import hr.josip.composeapp.data.common.Mock

data class FeedModel(
    val storyModels: List<StoryModel> = Mock.getStories(),
    val postModels: List<PostModel> = Mock.getPosts()
)