package hr.josip.composeapp.data.model.feed.response

import hr.josip.composeapp.data.common.User

data class Story(
    val id: Int,
    val user: User,
    val storyState: StoryState
)

enum class StoryState {
    UNREAD,
    LOADING,
    READ
}