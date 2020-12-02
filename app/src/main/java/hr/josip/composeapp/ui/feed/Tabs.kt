package hr.josip.composeapp.ui.feed

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import hr.josip.composeapp.R
import hr.josip.composeapp.ui.shared.compose.blue
import hr.josip.composeapp.ui.shared.compose.darkGrey

@Composable
fun Tabs() {
    var currentIndex by remember { mutableStateOf(0) }
    val tabTitles = listOf(
        stringResource(id = R.string.tab_news),
        stringResource(id = R.string.tab_groups),
        stringResource(id = R.string.tab_watch)
    )
    Surface(color = MaterialTheme.colors.surface) {
        Column(modifier = Modifier.fillMaxWidth()) {
            TabRow(
                selectedTabIndex = currentIndex, backgroundColor = MaterialTheme.colors.surface,
                contentColor = blue
            ) {
                tabTitles.forEachIndexed { index, title ->
                    Tab(
                        text = {
                            Text(
                                text = title,
                                style = MaterialTheme.typography.subtitle2,
                                color = if (index == currentIndex) blue else darkGrey
                            )
                        },
                        selected = currentIndex == index,
                        onClick = { currentIndex = index }
                    )
                }
            }
        }
    }
}