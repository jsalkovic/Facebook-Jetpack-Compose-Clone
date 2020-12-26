package hr.josip.composeapp.data.model.feed.response

import hr.josip.composeapp.data.common.User

data class Comment (
    val commentText: String,
    val user: User
)