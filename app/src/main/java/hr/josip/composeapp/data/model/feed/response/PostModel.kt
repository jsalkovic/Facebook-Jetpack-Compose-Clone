package hr.josip.composeapp.data.model.feed.response

import hr.josip.composeapp.data.common.User
import java.util.*

data class PostModel(
    val id: Int,
    val user: User,
    val date: Date = Date(),
    val text: String,
    val imageUrl: String,
    val reactions: Reactions = Reactions(),
    val comments: Int = 0,
    val shares: Int = 0
)