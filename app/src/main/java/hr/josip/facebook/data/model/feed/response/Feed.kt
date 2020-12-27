package hr.josip.facebook.data.model.feed.response

data class Feed(
    val stories: List<Story>,
    val posts: List<Post>
)