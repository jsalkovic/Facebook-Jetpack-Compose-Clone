package hr.josip.composeapp.ui.main

import androidx.activity.viewModels
import androidx.compose.animation.Crossfade
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.*
import dagger.hilt.android.AndroidEntryPoint
import hr.josip.composeapp.ui.feed.FeedViewModel
import hr.josip.composeapp.ui.home.Home
import hr.josip.composeapp.ui.shared.base.BaseActivity
import hr.josip.composeapp.ui.splash.Splash
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
@AndroidEntryPoint
class MainActivity : BaseActivity() {

    private lateinit var navController: NavHostController

    private val feedViewModel by viewModels<FeedViewModel>()

    @Composable
    override fun composeContent() {
        setupNavigationComponent()
    }

    @Composable
    private fun setupNavigationComponent() {
        navController = rememberNavController()
        NavHost(
            navController = navController,
            startDestination = MainScreen.SPLASH.route,
            builder = {
                composable(route = MainScreen.SPLASH.route, content = {
                    Crossfade(current = MainScreen.SPLASH.route) {
                        Splash(navController)
                    }
                })
                composable(route = MainScreen.HOME.route, content = {
                    Crossfade(current = MainScreen.HOME.route) {
                        Home(feedViewModel)
                    }
                })
            })
    }
}