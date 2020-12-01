package hr.josip.composeapp.data.model.feed.response

import hr.josip.composeapp.data.common.User

data class StoryModel(
    val id: Int,
    val user: User,
    var storyState: StoryState
)

enum class StoryState {
    UNREAD,
    LOADING,
    READ
}