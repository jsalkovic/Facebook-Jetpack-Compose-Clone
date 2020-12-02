package hr.josip.composeapp.data.model.feed.response

data class FeedModel(
    val storyModels: List<StoryModel>,
    val postModels: List<PostModel>
)