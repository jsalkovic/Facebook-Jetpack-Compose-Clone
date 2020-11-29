package hr.josip.composeapp.ui.feed

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import hr.josip.composeapp.R
import hr.josip.composeapp.data.model.feed.response.Story
import hr.josip.composeapp.ui.common.CircleImage
import hr.josip.composeapp.ui.common.CircleImageRes
import hr.josip.composeapp.ui.shared.compose.GlideImage
import hr.josip.composeapp.ui.shared.compose.blue

@Composable
fun StoryItem(story: Story, onClick: () -> Unit) {
    if (story.id == 0) {
        AddNewStory(onClick)
    } else {
        if (story.isRead) {
            ShowReadStory(story = story, onClick = onClick)
        } else {
            ShowUnreadStory(story = story, onClick = onClick)
        }
    }
}

@Composable
private fun ShowReadStory(story: Story, onClick: () -> Unit) {
    Surface(
        color = MaterialTheme.colors.surface,
        modifier = Modifier.preferredWidth(62.dp).padding(4.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CircleImage(url = story.user.avatarUrl, onClick = onClick)
            Text(
                text = story.user.name,
                style = MaterialTheme.typography.caption,
                color = MaterialTheme.colors.onSurface,
                modifier = Modifier.padding(top = 2.dp)
            )
        }
    }
}

@Composable
private fun ShowUnreadStory(story: Story, onClick: () -> Unit) {
    Surface(
        color = MaterialTheme.colors.surface,
        modifier = Modifier.preferredWidth(64.dp).padding(4.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier.fillMaxWidth().clip(CircleShape)
                    .background(MaterialTheme.colors.surface)
                    .border(width = 3.dp, color = blue, shape = CircleShape)
            ) {
                CircleImage(url = story.user.avatarUrl, onClick = onClick)
            }
            Text(
                textAlign = TextAlign.Center,
                text = story.user.name,
                style = MaterialTheme.typography.caption,
                color = blue,
                modifier = Modifier.padding(top = 2.dp)
            )
        }
    }
}



@Composable
private fun AddNewStory(onClick: () -> Unit) {
    Surface(
        color = MaterialTheme.colors.surface,
        modifier = Modifier.preferredWidth(64.dp).padding(4.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(modifier = Modifier.fillMaxWidth()) {
                CircleImageRes(resId = R.drawable.user_avatar)
                Box(
                    modifier = Modifier.preferredSize(20.dp).clip(CircleShape)
                        .background(blue)
                        .border(
                            width = 2.dp,
                            color = MaterialTheme.colors.surface,
                            shape = CircleShape
                        )
                        .align(Alignment.BottomEnd)
                ) {
                    Image(
                        asset = vectorResource(id = R.drawable.ic_add),
                        modifier = Modifier.fillMaxSize().padding(2.dp).clickable(
                            onClick = onClick
                        )
                    )
                }
            }
            Text(
                textAlign = TextAlign.Center,
                text = stringResource(id = R.string.new_story),
                style = MaterialTheme.typography.caption,
                color = MaterialTheme.colors.onSurface,
                modifier = Modifier.padding(top = 2.dp)
            )
        }
    }
}