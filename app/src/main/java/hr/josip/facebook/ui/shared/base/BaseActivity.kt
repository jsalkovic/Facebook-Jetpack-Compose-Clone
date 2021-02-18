package hr.josip.facebook.ui.shared.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.Composable
import androidx.activity.compose.setContent
import hr.josip.facebook.ui.shared.compose.ComposeAppTheme

abstract class BaseActivity : AppCompatActivity() {

    @Composable
    abstract fun ComposeContent()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeAppTheme {
                ComposeContent()
            }
        }
    }
}