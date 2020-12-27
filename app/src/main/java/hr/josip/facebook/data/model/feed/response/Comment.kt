package hr.josip.facebook.data.model.feed.response

import hr.josip.facebook.data.common.User
import java.util.*

data class Comment (
    val id: Int,
    val text: String,
    val date: Date,
    val user: User
)