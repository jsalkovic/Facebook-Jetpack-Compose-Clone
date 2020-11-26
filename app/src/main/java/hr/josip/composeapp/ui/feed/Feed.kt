package hr.josip.composeapp.ui.feed

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import hr.josip.composeapp.R
import hr.josip.composeapp.ui.common.Status
import hr.josip.composeapp.ui.common.Screen
import hr.josip.composeapp.ui.common.WithViewState
import hr.josip.composeapp.ui.home.HomeScreen

@Composable
fun Feed(feedViewModel: FeedViewModel) {
    Screen(topBar = { FeedToolbar() }) {
        Column(modifier = Modifier.fillMaxSize()) {
            Status({})
            Tabs()
            Text(
                text = HomeScreen.Feed.route,
                color = MaterialTheme.colors.onBackground
            )
        }
    }
    WithViewState(viewModel = feedViewModel) { feed ->
        feed.feed?.stories?.forEach { story ->
            Log.d(
                "FeedComposable",
                "Story --> ${story.user.name}, ${story.user.surname}, ${story.user.avatarUrl}, ${story.isRead}"
            )
        }
    }
    feedViewModel.getFeed()
}

@Composable
private fun FeedToolbar() {
    Surface(color = MaterialTheme.colors.primary) {
        Column(
            modifier = Modifier.fillMaxWidth().then(Modifier.height(56.dp)),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                modifier = Modifier.fillMaxSize().then(Modifier.padding(16.dp)),
                asset = vectorResource(id = R.drawable.ic_facebook_logo)
            )
        }
    }
}