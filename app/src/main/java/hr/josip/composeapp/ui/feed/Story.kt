package hr.josip.composeapp.ui.feed

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import hr.josip.composeapp.R
import hr.josip.composeapp.data.common.User
import hr.josip.composeapp.data.model.feed.response.Story
import hr.josip.composeapp.data.model.feed.response.StoryState
import hr.josip.composeapp.shared.manager.user.UserManager
import hr.josip.composeapp.ui.common.CircleImage
import hr.josip.composeapp.ui.shared.compose.blue
import hr.josip.composeapp.ui.shared.compose.lightGrey

@Composable
fun StoryItem(
    story: Story,
    onStoryClicked: (Story) -> Unit,
    onAddStoryClicked: () -> Unit,
    userManager: UserManager
) {
    if (story.user == userManager.getCurrentActiveUser()) {
        NewStory(userManager.getCurrentActiveUser(), onAddStoryClicked)
    } else when (story.storyState) {
        StoryState.UNREAD -> UnreadStory(story = story, onClick = onStoryClicked)
        StoryState.LOADING -> LoadingStory(story)
        StoryState.READ -> ReadStory(story = story, onClick = onStoryClicked)
    }
}

@Composable
private fun ReadStory(story: Story, onClick: (Story) -> Unit) {
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
                    .border(
                        width = 3.dp,
                        color = lightGrey,
                        shape = CircleShape
                    )
                    .clickable(onClick = { onClick.invoke(story) })
            ) {
                CircleImage(
                    model = story.user.avatarUrl,
                    modifier = Modifier.preferredSize(width = 56.dp, height = 56.dp).padding(4.dp)
                )
            }
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
private fun UnreadStory(story: Story, onClick: (Story) -> Unit) {
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
                    .clickable(onClick = { onClick.invoke(story) })
            ) {
                CircleImage(
                    model = story.user.avatarUrl,
                    modifier = Modifier.preferredSize(width = 56.dp, height = 56.dp).padding(4.dp)
                )
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
private fun LoadingStory(story: Story) {
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
            ) {
                CircularProgressIndicator(
                    modifier = Modifier.preferredSize(56.dp),
                    strokeWidth = 3.dp,
                    color = blue
                )
                CircleImage(
                    model = story.user.avatarUrl,
                    modifier = Modifier.preferredSize(width = 56.dp, height = 56.dp).padding(4.dp)
                )
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
private fun NewStory(user: User, onAddStoryClicked: () -> Unit) {
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
                modifier = Modifier.fillMaxWidth()
            ) {
                CircleImage(
                    model = user.avatarUrl,
                    modifier = Modifier.preferredSize(width = 56.dp, height = 56.dp).padding(4.dp)
                        .clickable(onClick = { onAddStoryClicked.invoke() })
                )
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
                        vectorResource(id = R.drawable.ic_add),
                        modifier = Modifier.fillMaxSize().padding(2.dp)
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