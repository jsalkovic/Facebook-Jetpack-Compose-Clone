package hr.josip.composeapp.data.model.feed.response

import hr.josip.composeapp.data.common.User
import java.util.*

data class Comment (
    val id: Int,
    val text: String,
    val date: Date,
    val user: User
)