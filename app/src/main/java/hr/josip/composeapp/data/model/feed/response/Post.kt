package hr.josip.composeapp.data.model.feed.response

import hr.josip.composeapp.data.common.User
import java.util.*
import kotlin.math.abs
import kotlin.random.Random

data class Post(
    val id: Int,
    val user: User,
    val date: Date = Date(abs(System.currentTimeMillis().minus(Random.nextLong()))),
    val text: String,
    val imageUrl: String? = null,
    val reactions: Reactions = Reactions(),
    val comments: Int = 0,
    val shares: Int = 0
)