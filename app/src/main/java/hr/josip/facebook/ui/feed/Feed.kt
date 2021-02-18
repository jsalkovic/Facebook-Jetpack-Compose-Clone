package hr.josip.facebook.ui.feed

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.AmbientContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import hr.josip.facebook.R
import hr.josip.facebook.data.model.feed.response.Feed
import hr.josip.facebook.data.model.feed.response.Story
import hr.josip.facebook.data.model.feed.response.StoryState
import hr.josip.facebook.shared.manager.user.UserManager
import hr.josip.facebook.ui.common.*
import hr.josip.facebook.ui.shared.compose.OnActive
import hr.josip.facebook.ui.shared.compose.OnDispose

private var toast: Toast? = null

@Composable
fun Feed(feedViewModel: FeedViewModel, userManager: UserManager) {
    HandleLifecycle(feedViewModel)
    Screen(topBar = { FeedToolbar() }) {
        HandleCommonState(viewModel = feedViewModel)
        WithViewState(viewModel = feedViewModel) { feedState ->
            HandleViewState(
                feedState,
                feedViewModel,
                userManager
            )
        }
        WithViewEffect(viewModel = feedViewModel) { feedEffect -> HandleViewEffect(feedEffect) }
    }
}

@Composable
private fun HandleViewState(feedState: FeedState, feedViewModel: FeedViewModel, userManager: UserManager) {
    feedState.feed?.let { feed -> ShowFeed(feed, feedViewModel, userManager) }
}

@Composable
private fun HandleViewEffect(feedEffect: FeedEffect) {
    when (feedEffect) {
        FeedEffect.AddNewStoryUnavailable -> toast = Toast.makeText(
            AmbientContext.current,
            AmbientContext.current.getString(R.string.add_new_story_unavailable),
            Toast.LENGTH_LONG
        ).apply { show() }
        is FeedEffect.SharePostUnavailable -> toast = Toast.makeText(
            AmbientContext.current,
            AmbientContext.current.getString(R.string.share_post_unavailable),
            Toast.LENGTH_LONG
        ).apply { show() }
        is FeedEffect.ShowPostDetailsUnavailable -> toast = Toast.makeText(
            AmbientContext.current,
            AmbientContext.current.getString(R.string.post_detail_unavailable),
            Toast.LENGTH_LONG
        ).apply { show() }
        is FeedEffect.ShowStoryContentUnavailable -> toast = Toast.makeText(
            AmbientContext.current,
            AmbientContext.current.getString(R.string.preview_story_unavailable),
            Toast.LENGTH_LONG
        ).apply { show() }
    }
}

@Composable
private fun HandleLifecycle(feedViewModel: FeedViewModel) {
    OnActive {
        feedViewModel.intent(FeedEvent.GetFeed)
    }
    OnDispose(feedViewModel) {
        toast?.cancel()
    }
}


@Composable
private fun ShowFeed(feed: Feed, feedViewModel: FeedViewModel, userManager: UserManager) {
    LazyColumn(
        modifier = Modifier.fillMaxSize().background(color = MaterialTheme.colors.background)
            .padding(bottom = 56.dp)
    ) {
        item {
            Input(
                userManager.getCurrentActiveUser(),
                stringResource(id = R.string.status_hint)
            ) { status ->
                feedViewModel.intent(FeedEvent.UpdateStatus(status))
            }
            Stories(feed.stories, feedViewModel, userManager)
        }
        items(
            items = feed.posts,
        ) { post ->
            PostItem(
                post = post,
                userManager = userManager,
                onClick = { feedViewModel.intent(FeedEvent.ShowPostDetails(it)) },
                onLikeClicked = { feedViewModel.intent(FeedEvent.LikeClicked(it)) },
                onAddComment = { commentedPost, comment ->
                    feedViewModel.intent(
                        FeedEvent.AddComment(
                            commentedPost,
                            comment
                        )
                    )
                },
                onShareClicked = { feedViewModel.intent(FeedEvent.SharPost(it)) }
            )
        }
    }
}

@Composable
private fun Stories(
    stories: List<Story>,
    feedViewModel: FeedViewModel,
    userManager: UserManager
) {
    Surface(
        modifier = Modifier.fillMaxWidth().padding(top = 8.dp),
        color = MaterialTheme.colors.surface
    ) {
        LazyRow(
            content = {
                items(stories) { story ->
                    StoryItem(
                        story = story,
                        userManager = userManager,
                        onStoryClicked = {
                            when (it.storyState) {
                                StoryState.UNREAD -> feedViewModel.intent(
                                    FeedEvent.MarkStoryAsRead(
                                        story
                                    )
                                )
                                StoryState.READ -> feedViewModel.intent(
                                    FeedEvent.ShowStoryContent(
                                        story
                                    )
                                )
                                StoryState.LOADING -> Unit
                            }
                        },
                        onAddStoryClicked = {
                            feedViewModel.intent(FeedEvent.AddNewUserStory)
                        }
                    )
                }
            },
            modifier = Modifier.padding(top = 8.dp, bottom = 8.dp)
        )
    }
}

@Composable
private fun FeedToolbar() {
    Surface(color = MaterialTheme.colors.primary) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                vectorResource(id = R.drawable.ic_facebook_logo),
                contentDescription = stringResource(id = R.string.app_name),
                modifier = Modifier.fillMaxWidth().height(56.dp).padding(16.dp)
            )
        }
    }
}