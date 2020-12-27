package hr.josip.composeapp.ui.home

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import hr.josip.composeapp.shared.manager.user.UserManager
import hr.josip.composeapp.ui.feed.Feed
import hr.josip.composeapp.ui.feed.FeedViewModel

@Composable
fun Home(feedViewModel: FeedViewModel, userManager: UserManager) {
    val navController = rememberNavController()
    Scaffold(bottomBar = { SetupBottomNav(navController, userManager.getCurrentActiveUser()) }) {
        NavHost(navController = navController, startDestination = HomeScreen.Feed.route, builder = {
            composable(route = HomeScreen.Feed.route) {
                Crossfade(current = HomeScreen.Feed.route) {
                    Feed(feedViewModel, userManager)
                }
            }
            composable(route = HomeScreen.Groups.route) {
                Crossfade(current = HomeScreen.Groups.route) {
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = HomeScreen.Groups.route,
                            color = MaterialTheme.colors.onBackground,
                        )
                    }
                }
            }
            composable(route = HomeScreen.Chat.route) {
                Crossfade(current = HomeScreen.Chat.route) {
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = HomeScreen.Chat.route,
                            color = MaterialTheme.colors.onBackground,
                        )
                    }
                }
            }
            composable(route = HomeScreen.Notifications.route) {
                Crossfade(current = HomeScreen.Notifications.route) {
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = HomeScreen.Notifications.route,
                            color = MaterialTheme.colors.onBackground,
                        )
                    }
                }
            }
            composable(route = HomeScreen.Profile.route) {
                Crossfade(current = HomeScreen.Profile.route) {
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = HomeScreen.Profile.route,
                            color = MaterialTheme.colors.onBackground,
                        )
                    }
                }
            }
        })
    }
}
