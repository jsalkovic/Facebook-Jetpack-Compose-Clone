package hr.josip.composeapp.ui.home

import androidx.compose.animation.Crossfade
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import hr.josip.composeapp.shared.manager.user.UserManager
import hr.josip.composeapp.ui.feed.Feed
import hr.josip.composeapp.ui.feed.FeedViewModel

@Composable
fun Home(feedViewModel: FeedViewModel, userManager: UserManager) {
    val navController = rememberNavController()
    Scaffold(bottomBar = { SetupBottomNav(navController) }) {
        NavHost(navController = navController, startDestination = HomeScreen.Feed.route, builder = {
            composable(route = HomeScreen.Feed.route) {
                Crossfade(current = HomeScreen.Feed.route) {
                    Feed(feedViewModel, userManager)
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
