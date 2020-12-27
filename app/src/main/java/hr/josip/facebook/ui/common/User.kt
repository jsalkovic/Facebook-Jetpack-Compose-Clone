package hr.josip.facebook.ui.common

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.preferredSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import hr.josip.facebook.data.common.User
import hr.josip.facebook.ui.shared.compose.green

@Composable
fun UserPicture(user: User){
    if (user.isOnline) UserOnline(user) else UserOffline(user)
}

@Composable
private fun UserOnline(user: User) {
    Box(
        modifier = Modifier.preferredSize(40.dp)
    ) {
        CircleImage(
            model = user.avatarUrl,
            modifier = Modifier.fillMaxSize()
        )
        Box(
            modifier = Modifier.preferredSize(15.dp).clip(CircleShape)
                .background(green)
                .border(
                    width = 2.dp,
                    color = MaterialTheme.colors.surface,
                    shape = CircleShape
                )
                .align(Alignment.BottomEnd)
        )
    }
}

@Composable
private fun UserOffline(user: User) {
    CircleImage(
        model = user.avatarUrl,
        modifier = Modifier.preferredSize(40.dp)
    )
}