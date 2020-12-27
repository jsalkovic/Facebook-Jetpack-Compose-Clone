package hr.josip.facebook.data.model.feed.response

import hr.josip.facebook.data.common.User

data class Story(
    val id: Int,
    val imageUrl: String? = null,
    val user: User,
    val storyState: StoryState
)

enum class StoryState {
    UNREAD,
    LOADING,
    READ
}