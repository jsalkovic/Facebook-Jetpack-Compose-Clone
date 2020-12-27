package hr.josip.composeapp.ui.shared.compose

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorPalette = darkColors(
    primary = lightBlack,
    onPrimary = Color.White,
    primaryVariant = black,
    secondary = black,
    onSecondary = Color.White,
    background = black,
    onBackground = Color.White,
    surface = lightBlack,
    onSurface = Color.White,
    error = Color.Red,
    onError = Color.White,
)

private val LightColorPalette = lightColors(
    primary = Color.White,
    onPrimary = blue,
    secondary = lightGrey,
    onSecondary = black,
    primaryVariant = Color.White,
    background = Color.LightGray,
    onBackground = black,
    surface = Color.White,
    onSurface = black,
    error = Color.Red,
    onError = Color.White,
)

@Composable
fun ComposeAppTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = typography,
        shapes = shapes,
        content = content
    )
}