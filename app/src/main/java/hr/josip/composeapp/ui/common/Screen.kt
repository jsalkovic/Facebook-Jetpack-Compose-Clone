package hr.josip.composeapp.ui.common

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable

@Composable
fun Screen(
    topBar: @Composable () -> Unit = { Toolbar() },
    content: @Composable (paddingValues: PaddingValues) -> Unit
) {
    Scaffold(
        topBar = topBar,
        bodyContent = content
    )
}