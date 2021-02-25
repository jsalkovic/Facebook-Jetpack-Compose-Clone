package hr.josip.facebook.ui.splash

import android.os.Handler
import android.os.Looper
import androidx.compose.foundation.layout.*
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.navigate
import androidx.navigation.compose.popUpTo
import hr.josip.facebook.R
import hr.josip.facebook.ui.common.CircleImage
import hr.josip.facebook.ui.main.MainScreen
import hr.josip.facebook.ui.shared.compose.blue

const val SPLASH_DURATION = 1000L

@Composable
fun Splash(navController: NavHostController) {
    Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.surface) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CircleImage(
                model = R.drawable.ic_facebook,
                modifier = Modifier.size(width = 56.dp, height = 56.dp).padding(0.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))
            CircularProgressIndicator(
                modifier = Modifier.width(23.dp).height(23.dp),
                strokeWidth = 2.dp,
                color = blue
            )
        }
    }
    Handler(Looper.getMainLooper()).postDelayed(
        {
            navController.navigate(
                route = MainScreen.HOME.route,
                builder = {
                    popUpTo(
                        route = MainScreen.SPLASH.route,
                        popUpToBuilder = { inclusive = true })
                })
        },
        SPLASH_DURATION
    )
}