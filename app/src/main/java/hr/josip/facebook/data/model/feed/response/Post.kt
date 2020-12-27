package hr.josip.facebook.data.model.feed.response

import hr.josip.facebook.data.common.User
import java.util.*
import kotlin.math.abs
import kotlin.random.Random

data class Post(
    val id: Int,
    val user: User,
    val date: Date = Date(abs(System.currentTimeMillis().minus(Random.nextLong()))),
    val text: String,
    val imageUrl: String? = null,
    val likes: Int = Random.nextInt(100),
    val comments: List<Comment> = arrayListOf(),
    val shares: Int = Random.nextInt(100),
    val isLikedByCurrentUser: Boolean = false
)