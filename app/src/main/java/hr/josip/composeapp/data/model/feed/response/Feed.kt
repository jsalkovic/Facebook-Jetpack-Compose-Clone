package hr.josip.composeapp.data.model.feed.response

data class Feed(
    val stories: List<Story>,
    val posts: List<Post>
)