package hr.josip.composeapp.ui.feed

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumnFor
import androidx.compose.foundation.lazy.LazyRowFor
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import hr.josip.composeapp.R
import hr.josip.composeapp.data.model.feed.response.PostModel
import hr.josip.composeapp.data.model.feed.response.StoryModel
import hr.josip.composeapp.data.model.feed.response.StoryState
import hr.josip.composeapp.ui.common.Status
import hr.josip.composeapp.ui.common.Screen
import hr.josip.composeapp.ui.common.WithViewState

@Composable
fun Feed(feedViewModel: FeedViewModel) {
    Screen(topBar = { FeedToolbar() }) {
        Column(modifier = Modifier.fillMaxSize()) {
            WithViewState(
                viewModel = feedViewModel,
                viewStateChanged = { viewState ->
                    viewState.feedModel?.let { feed ->
                        ShowStories(feed.storyModels, feedViewModel)
                        ShowPosts(feed.postModels)
                    }
                },
                viewEventOccurred = { Unit }
            )
            feedViewModel.getFeed()
        }
    }
}

@Composable
private fun ShowStories(storyModels: List<StoryModel>, feedViewModel: FeedViewModel) {
    Surface(
        modifier = Modifier.fillMaxWidth().padding(top = 8.dp),
        color = MaterialTheme.colors.surface
    ) {
        LazyRowFor(
            items = storyModels,
            modifier = Modifier.padding(top = 8.dp, bottom = 8.dp)
        ) { story ->
            StoryItem(storyModel = story) {
                if (story.storyState == StoryState.UNREAD)
                    feedViewModel.markStoryAsRead(story)
            }
        }
    }
}

@Composable
private fun ShowPosts(postModels: List<PostModel>) {
    LazyColumnFor(
        items = postModels,
        modifier = Modifier.padding(top = 8.dp, bottom = 8.dp)
    ) { post ->
        PostItem(postModel = post) { Unit }
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
            Status { Unit }
        }
    }
}