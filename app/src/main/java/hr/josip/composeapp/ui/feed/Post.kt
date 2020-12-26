package hr.josip.composeapp.ui.feed

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import hr.josip.composeapp.R
import hr.josip.composeapp.data.model.feed.response.Post
import hr.josip.composeapp.ui.common.CircleImage
import hr.josip.composeapp.ui.shared.compose.GlideImage
import hr.josip.composeapp.ui.shared.compose.blue
import hr.josip.composeapp.ui.shared.compose.green
import java.text.SimpleDateFormat
import java.util.*

const val POST_DATE_FORMAT_PATTERN = "MMM dd HH:mm"

@Composable
fun PostItem(post: Post,
             onClick: (Post) -> Unit,
             onLikeClicked: (Post) -> Unit,
             onAddComment: (Post) -> Unit,
             onShareClicked: (Post) -> Unit
) {
    Surface(
        color = MaterialTheme.colors.surface,
        modifier = Modifier.fillMaxWidth().padding(top = 8.dp)
            .clickable(onClick = { onClick.invoke(post) })
    ) {
        Column(modifier = Modifier.fillMaxWidth()) {
            UserDetails(post)
            PostContent(post)
            ReactionsContent(post, onLikeClicked, onAddComment, onShareClicked)
        }
    }
}

@Composable
private fun UserDetails(post: Post) {
    Row(
        modifier = Modifier.fillMaxWidth().padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        if (post.user.isOnline) {
            UserOnline(post = post)
        } else {
            UserOffline(post = post)
        }
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
                text = SimpleDateFormat(POST_DATE_FORMAT_PATTERN, Locale.ENGLISH).format(post.date),
                style = MaterialTheme.typography.caption,
                color = MaterialTheme.colors.onSurface
            )
        }
    }
}

@Composable
private fun UserOnline(post: Post) {
    Box(
        modifier = Modifier.preferredSize(width = 48.dp, height = 48.dp)
    ) {
        CircleImage(
            model = post.user.avatarUrl,
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
private fun UserOffline(post: Post) {
    CircleImage(
        model = post.user.avatarUrl,
        modifier = Modifier.preferredSize(width = 48.dp, height = 48.dp)
    )
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

@Composable
private fun ReactionsContent(
    post: Post,
    onLikeClicked: (Post) -> Unit,
    onAddComment: (Post) -> Unit,
    onShareClicked: (Post) -> Unit
) {
    Row(modifier = Modifier.fillMaxWidth().padding(16.dp)) {
        Likes(post, onLikeClicked)
        Comments(post, onAddComment)
        Share(post, onShareClicked)
    }
}

@Composable
private fun Likes(post: Post, onLikeClicked: (Post) -> Unit) {
    Row(modifier = Modifier.clickable(onClick = { onLikeClicked.invoke(post) })) {
        Image(
            vectorResource(id = R.drawable.ic_thumb_up),
            modifier = Modifier.preferredSize(24.dp).align(Alignment.CenterVertically),
            colorFilter = if (post.isLikedByCurrentUser) ColorFilter.tint(blue) else ColorFilter.tint(
                MaterialTheme.colors.onSurface
            )
        )
        Text(
            text = post.likes.toString(),
            style = MaterialTheme.typography.body1,
            color = MaterialTheme.colors.onSurface,
            modifier = Modifier.padding(start = 8.dp).align(Alignment.CenterVertically)
        )
    }
}

@Composable
private fun Comments(post: Post, onAddComment: (Post) -> Unit) {
    Row(
        modifier = Modifier.padding(start = 16.dp)
            .clickable(onClick = { onAddComment.invoke(post) })
    ) {
        Image(
            vectorResource(id = R.drawable.ic_comment),
            modifier = Modifier.preferredSize(24.dp).align(Alignment.CenterVertically),
            colorFilter = ColorFilter.tint(MaterialTheme.colors.onSurface)
        )
        Text(
            text = post.comments.size.toString(),
            style = MaterialTheme.typography.body1,
            color = MaterialTheme.colors.onSurface,
            modifier = Modifier.padding(start = 8.dp).align(Alignment.CenterVertically)
        )
    }
}

@Composable
private fun Share(post: Post, onShareClicked: (Post) -> Unit) {
    Row(
        modifier = Modifier.padding(start = 16.dp)
            .clickable(onClick = { onShareClicked.invoke(post) })
    ) {
        Image(
            vectorResource(id = R.drawable.ic_share),
            modifier = Modifier.preferredSize(24.dp).align(Alignment.CenterVertically),
            colorFilter = ColorFilter.tint(MaterialTheme.colors.onSurface)
        )
        Text(
            text = post.shares.toString(),
            style = MaterialTheme.typography.body1,
            color = MaterialTheme.colors.onSurface,
            modifier = Modifier.padding(start = 8.dp).align(Alignment.CenterVertically)
        )
    }
}