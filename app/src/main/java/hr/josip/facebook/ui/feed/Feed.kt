package hr.josip.facebook.ui.feed

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import hr.josip.facebook.R
import hr.josip.facebook.data.model.feed.response.Feed
import hr.josip.facebook.data.model.feed.response.Story
import hr.josip.facebook.data.model.feed.response.StoryState
import hr.josip.facebook.shared.manager.user.UserManager
import hr.josip.facebook.ui.common.*

@Composable
fun Feed(feedViewModel: FeedViewModel, userManager: UserManager) {
    Screen(topBar = { FeedToolbar() }) {
        HandleCommonState(viewModel = feedViewModel)
        HandleViewState(viewModel = feedViewModel) { viewState ->
            viewState.feed?.let { feed -> ShowFeed(feed, feedViewModel, userManager) }
        }
        HandleViewEvent(viewModel = feedViewModel) { }
        feedViewModel.init()
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
                feedViewModel.updateStatus(status)
            }
            Stories(feed.stories, feedViewModel, userManager)
        }
        items(
            items = feed.posts,
        ) { post ->
            PostItem(
                post = post,
                userManager = userManager,
                onClick = { feedViewModel.showPostDetails(it) },
                onLikeClicked = { feedViewModel.onLikeClicked(it) },
                onAddComment = { commentedPost, comment -> feedViewModel.addComment(commentedPost, comment) },
                onShareClicked = { feedViewModel.sharePost(it) }
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
                                StoryState.UNREAD -> feedViewModel.markStoryAsRead(story)
                                StoryState.READ -> feedViewModel.showStoryContent(story)
                                StoryState.LOADING -> Unit
                            }
                        },
                        onAddStoryClicked = {
                            feedViewModel.addNewUserStory()
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
                modifier = Modifier.fillMaxWidth().height(56.dp).padding(16.dp)
            )
        }
    }
}