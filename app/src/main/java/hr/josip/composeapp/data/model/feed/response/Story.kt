package hr.josip.composeapp.data.model.feed.response

import hr.josip.composeapp.data.common.User

data class Story(
    val user: User,
    val isRead: Boolean
)