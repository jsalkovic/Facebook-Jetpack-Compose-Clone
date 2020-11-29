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
import hr.josip.composeapp.data.model.feed.response.Post
import hr.josip.composeapp.data.model.feed.response.Story
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
                    viewState.feed?.let { feed ->
                        ShowStories(feed.stories)
                        ShowPosts(feed.posts)
                    }
                },
                eventStateChanged = { Unit }
            )
            feedViewModel.getFeed()
        }
    }
}

@Composable
private fun ShowStories(stories: List<Story>) {
    Surface(modifier = Modifier.fillMaxWidth().padding(top = 8.dp), color = MaterialTheme.colors.surface) {
        LazyRowFor(
            items = stories,
            modifier = Modifier.padding(top = 8.dp, bottom = 8.dp)
        ) { story ->
            StoryItem(story = story) { Unit }
        }
    }
}

@Composable
private fun ShowPosts(posts: List<Post>) {
    LazyColumnFor(
        items = posts,
        modifier = Modifier.padding(top = 8.dp, bottom = 8.dp)
    ) { post ->
        PostItem(post = post) { Unit }
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