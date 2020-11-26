package hr.josip.composeapp.ui.home

import androidx.compose.animation.Crossfade
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import hr.josip.composeapp.ui.feed.Feed
import hr.josip.composeapp.ui.feed.FeedViewModel

@Composable
fun Home(feedViewModel: FeedViewModel) {
    val navController = rememberNavController()
    Scaffold(bottomBar = { SetupBottomNav(navController) }) {
        NavHost(navController = navController, startDestination = HomeScreen.Feed.route, builder = {
            composable(route = HomeScreen.Feed.route) {
                Crossfade(current = HomeScreen.Feed.route) {
                    Feed(feedViewModel)
                }
            }
            composable(route = HomeScreen.Groups.route) {
                Crossfade(current = HomeScreen.Groups.route) {
                    Text(
                        text = HomeScreen.Groups.route,
                        color = MaterialTheme.colors.onBackground
                    )
                }
            }
            composable(route = HomeScreen.Chat.route) {
                Crossfade(current = HomeScreen.Chat.route) {
                    Text(
                        text = HomeScreen.Chat.route,
                        color = MaterialTheme.colors.onBackground
                    )
                }
            }
            composable(route = HomeScreen.Notifications.route) {
                Crossfade(current = HomeScreen.Notifications.route) {
                    Text(
                        text = HomeScreen.Notifications.route,
                        color = MaterialTheme.colors.onBackground
                    )
                }
            }
            composable(route = HomeScreen.Profile.route) {
                Crossfade(current = HomeScreen.Profile.route) {
                    Text(
                        text = HomeScreen.Profile.route,
                        color = MaterialTheme.colors.onBackground
                    )
                }
            }
        })
    }
}

/*@Composable
private fun ScreenContent(viewState: HomeState, bottomDrawerState: BottomDrawerState) {
    SetupScreen(topBar = {
        val compositionName = viewState.selectedCompetition?.name
        SetupTopBar(
            toolbarTitle = compositionName ?: stringResource(id = R.string.app_name),
            navigationIconId = R.drawable.ic_menu,
            onNavigationIconClickListener = { changeBottomDrawerState(bottomDrawerState) })
    }) {
        viewState.matches?.forEach { match ->
            Log.d(
                "HomeComposable",
                "${match.homeTeam.name} (${match.score.fullTime.homeTeam} :  ${match.score.fullTime.awayTeam})  ${match.awayTeam.name}"
            )
        }
    }
}

@ExperimentalCoroutinesApi
@Composable
private fun DrawerContent(
    viewState: HomeState,
    viewModel: HomeViewModel,
    state: BottomDrawerState
) = ColumnScope.also {
    LazyColumnFor(items = viewState.drawerElements!!) { competition ->
        DrawerItem(
            isSelected = viewState.selectedCompetition != null && viewState.selectedCompetition == competition,
            competition = competition,
            onClick = {
                state.close()
                viewModel.changeCurrentCompetition(competition)
            })
    }
}

private fun changeBottomDrawerState(bottomDrawerState: BottomDrawerState) {
    if (bottomDrawerState.isClosed) bottomDrawerState.open() else bottomDrawerState.close()
}*/
