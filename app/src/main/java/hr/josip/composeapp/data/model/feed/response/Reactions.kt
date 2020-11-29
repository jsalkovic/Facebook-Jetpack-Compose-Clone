package hr.josip.composeapp.data.model.feed.response

data class Reactions (
    val like: Int = 0,
    val love: Int = 0,
    val haha: Int = 0,
    val wow: Int = 0,
    val sad: Int = 0,
    val angry: Int = 0
)