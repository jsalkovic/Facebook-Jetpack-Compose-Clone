package hr.josip.facebook.data.common

data class User(
    val id: Int,
    val name: String,
    val avatarUrl: String,
    val isOnline: Boolean = false,
)