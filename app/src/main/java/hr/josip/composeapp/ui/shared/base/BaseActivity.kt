package hr.josip.composeapp.ui.shared.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.setContent
import hr.josip.composeapp.ui.shared.compose.ComposeAppTheme

abstract class BaseActivity : AppCompatActivity() {

    @Composable
    abstract fun composeContent()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeAppTheme {
                composeContent()
            }
        }
    }
}