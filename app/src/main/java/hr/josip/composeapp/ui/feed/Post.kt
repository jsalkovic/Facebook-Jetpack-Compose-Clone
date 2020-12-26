package hr.josip.composeapp.ui.feed

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import hr.josip.composeapp.data.model.feed.response.Post
import hr.josip.composeapp.ui.common.CircleImage
import hr.josip.composeapp.ui.shared.compose.GlideImage
import java.text.SimpleDateFormat
import java.util.*

@Composable
fun PostItem(post: Post, onClick: (Post) -> Unit) {
    Surface(
        color = MaterialTheme.colors.surface,
        modifier = Modifier.fillMaxWidth().padding(top = 8.dp)
            .clickable(onClick = { onClick.invoke(post) })
    ) {
        Column(modifier = Modifier.fillMaxWidth()) {
            UserDetails(post)
            PostContent(post)
        }
    }
}

@Composable
private fun UserDetails(post: Post) {
    Row(
        modifier = Modifier.fillMaxWidth().padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        CircleImage(
            model = post.user.avatarUrl,
            modifier = Modifier.preferredSize(width = 48.dp, height = 48.dp)
        )
        Column(
            modifier = Modifier.fillMaxWidth().padding(start = 8.dp),
        ) {
            Text(
                text = post.user.name,
                style = MaterialTheme.typography.subtitle1,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colors.onSurface
            )
            Text(
                text = SimpleDateFormat("MMM dd HH:mm", Locale.ENGLISH).format(post.date),
                style = MaterialTheme.typography.caption,
                color = MaterialTheme.colors.onSurface
            )
        }
    }
}

@Composable
private fun PostContent(post: Post) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = post.text,
            style = MaterialTheme.typography.body1,
            modifier = Modifier.padding(start = 16.dp, end = 16.dp, bottom = 8.dp),
            color = MaterialTheme.colors.onSurface
        )
        post.imageUrl?.let { imageUrl ->
            GlideImage(
                model = imageUrl,
                modifier = Modifier.fillMaxWidth().padding(16.dp)
                    .clip(RoundedCornerShape(8.dp))
            )
        }

    }
}

/*@Composable
private fun AddReactions(reactions: Reactions) {
    Row(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = post.text,
            style = MaterialTheme.typography.body2,
            modifier = Modifier.padding(start = 16.dp, end = 16.dp),
            color = MaterialTheme.colors.onSurface
        )
        GlideImage(
            model = post.imageUrl,
            modifier = Modifier.fillMaxWidth().padding(16.dp)
                .clip(RoundedCornerShape(8.dp))
        )
    }
}*/