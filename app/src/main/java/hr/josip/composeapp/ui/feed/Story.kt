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
import hr.josip.composeapp.data.model.feed.response.StoryModel
import hr.josip.composeapp.data.model.feed.response.StoryState
import hr.josip.composeapp.shared.manager.user.UserManager
import hr.josip.composeapp.ui.common.CircleImage
import hr.josip.composeapp.ui.shared.compose.blue
import hr.josip.composeapp.ui.shared.compose.lightGrey

@Composable
fun StoryItem(
    storyModel: StoryModel,
    onStoryClicked: (StoryModel) -> Unit,
    onAddStoryClicked: () -> Unit,
    userManager: UserManager
) {
    if (storyModel.user == userManager.getCurrentActiveUser()) {
        NewStory(userManager.getCurrentActiveUser(), onAddStoryClicked)
    } else when (storyModel.storyState) {
        StoryState.UNREAD -> UnreadStory(storyModel = storyModel, onClick = onStoryClicked)
        StoryState.LOADING -> LoadingStory(storyModel)
        StoryState.READ -> ReadStory(storyModel = storyModel, onClick = onStoryClicked)
    }
}

@Composable
private fun ReadStory(storyModel: StoryModel, onClick: (StoryModel) -> Unit) {
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
                    .clickable(onClick = { onClick.invoke(storyModel) })
            ) {
                CircleImage(model = storyModel.user.avatarUrl)
            }
            Text(
                text = storyModel.user.name,
                style = MaterialTheme.typography.caption,
                color = MaterialTheme.colors.onSurface,
                modifier = Modifier.padding(top = 2.dp)
            )
        }
    }
}

@Composable
private fun UnreadStory(storyModel: StoryModel, onClick: (StoryModel) -> Unit) {
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
                    .clickable(onClick = { onClick.invoke(storyModel) })
            ) {
                CircleImage(model = storyModel.user.avatarUrl)
            }
            Text(
                textAlign = TextAlign.Center,
                text = storyModel.user.name,
                style = MaterialTheme.typography.caption,
                color = blue,
                modifier = Modifier.padding(top = 2.dp)
            )
        }
    }
}

@Composable
private fun LoadingStory(storyModel: StoryModel) {
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
                CircleImage(model = storyModel.user.avatarUrl)
            }
            Text(
                textAlign = TextAlign.Center,
                text = storyModel.user.name,
                style = MaterialTheme.typography.caption,
                color = blue,
                modifier = Modifier.padding(top = 2.dp)
            )
        }
    }
}

@Composable
private fun NewStory(user: User, onClick: () -> Unit) {
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
                    .clickable(onClick = { onClick.invoke() })
            ) {
                CircleImage(model = user.avatarUrl)
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