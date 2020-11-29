package hr.josip.composeapp.data.model.feed.response

import hr.josip.composeapp.data.common.Mock

data class Feed(
    val stories: List<Story> = Mock.getStories(),
    val posts: List<Post> = Mock.getPosts()
)