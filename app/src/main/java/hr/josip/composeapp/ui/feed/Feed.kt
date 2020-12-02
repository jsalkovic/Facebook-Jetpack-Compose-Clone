package hr.josip.composeapp.ui.feed

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRowFor
import androidx.compose.foundation.lazy.LazyRowForIndexed
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import hr.josip.composeapp.R
import hr.josip.composeapp.data.model.feed.response.FeedModel
import hr.josip.composeapp.data.model.feed.response.StoryModel
import hr.josip.composeapp.data.model.feed.response.StoryState
import hr.josip.composeapp.shared.manager.user.UserManager
import hr.josip.composeapp.ui.common.*

@Composable
fun Feed(feedViewModel: FeedViewModel, userManager: UserManager) {
    Screen(topBar = { FeedToolbar() }) {
        Column(modifier = Modifier.fillMaxSize()) {
            HandleCommonState(viewModel = feedViewModel)
            HandleViewState(viewModel = feedViewModel) { viewState ->
                viewState.feedModel?.let { feed -> ShowFeed(feed, feedViewModel, userManager) }
            }
            HandleViewEvent(viewModel = feedViewModel) { }
            feedViewModel.init()
        }
    }
}

@Composable
private fun ShowFeed(feedModel: FeedModel, feedViewModel: FeedViewModel, userManager: UserManager) {
    LazyColumn(
        modifier = Modifier.fillMaxWidth().background(color = MaterialTheme.colors.background)
    ) {
        item {
            Status { status -> feedViewModel.updateStatus(status) }
            Stories(feedModel.storyModels, feedViewModel, userManager)
        }
        items(
            items = feedModel.postModels,
        ) { post -> PostItem(postModel = post) { Unit } }
    }
}

@Composable
private fun Stories(
    storyModels: List<StoryModel>,
    feedViewModel: FeedViewModel,
    userManager: UserManager
) {
    Surface(
        modifier = Modifier.fillMaxWidth().padding(top = 8.dp),
        color = MaterialTheme.colors.surface
    ) {
        LazyRowFor(
            items = storyModels,
            modifier = Modifier.padding(top = 8.dp, bottom = 8.dp)
        ) { story ->
            StoryItem(
                storyModel = story,
                userManager = userManager,
                onStoryClicked = {
                    when (it.storyState) {
                        StoryState.UNREAD -> feedViewModel.markStoryAsRead(story)
                        StoryState.READ -> Unit
                        StoryState.LOADING -> Unit
                    }
                },
                onAddStoryClicked = {}
            )
        }
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
                modifier = Modifier.fillMaxWidth().height(56.dp).padding(16.dp),
                asset = vectorResource(id = R.drawable.ic_facebook_logo)
            )
        }
    }
}