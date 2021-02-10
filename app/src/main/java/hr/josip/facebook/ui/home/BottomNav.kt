package hr.josip.facebook.ui.home

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.preferredSize
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.KEY_ROUTE
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.navigate
import hr.josip.facebook.R
import hr.josip.facebook.data.common.User
import hr.josip.facebook.ui.common.CircleImage
import hr.josip.facebook.ui.shared.compose.blue
import hr.josip.facebook.ui.shared.compose.darkGrey

private enum class ScreenRoute(val route: String) {
    FEED("Feed"),
    GROUPS("Groups"),
    CHAT("Chat"),
    NOTIFICATIONS("Notifications"),
    PROFILE("Profile")
}


sealed class HomeScreen(val route: String, @DrawableRes val drawableId: Int) {
    object Feed : HomeScreen(ScreenRoute.FEED.route, R.drawable.ic_home)
    object Groups : HomeScreen(ScreenRoute.GROUPS.route, R.drawable.ic_groups)
    object Chat : HomeScreen(ScreenRoute.CHAT.route, R.drawable.ic_chat)
    object Notifications : HomeScreen(ScreenRoute.NOTIFICATIONS.route, R.drawable.ic_notifications)
    object Profile : HomeScreen(ScreenRoute.PROFILE.route, R.drawable.ic_person)
}


@Composable
fun SetupBottomNav(
    navController: NavHostController,
    user: User
) {
    val items = listOf(
        HomeScreen.Feed,
        HomeScreen.Groups,
        HomeScreen.Chat,
        HomeScreen.Notifications,
        HomeScreen.Profile
    )
    BottomNavigation(backgroundColor = MaterialTheme.colors.primaryVariant) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.arguments?.getString(KEY_ROUTE)
        items.forEach { screen ->
            BottomNavigationItem(
                selectedContentColor = if (screen == HomeScreen.Profile) Color.Transparent else blue,
                unselectedContentColor = if (screen == HomeScreen.Profile) Color.Transparent else darkGrey,
                icon = {
                    if (screen is HomeScreen.Profile)
                        CircleImage(
                            model = user.avatarUrl,
                            modifier = Modifier.preferredSize(width = 24.dp, height = 24.dp)
                        )
                    else Icon(
                        vectorResource(id = screen.drawableId),
                        contentDescription = stringResource(id = R.string.app_name)
                    )
                },
                selected = currentRoute == screen.route,
                onClick = {
                    navController.popBackStack(navController.graph.startDestination, false)
                    if (currentRoute != screen.route) {
                        navController.navigate(screen.route)
                    }
                }
            )
        }
    }
}
