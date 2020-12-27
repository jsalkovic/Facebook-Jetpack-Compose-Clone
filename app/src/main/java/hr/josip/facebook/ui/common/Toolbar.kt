package hr.josip.facebook.ui.common

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import hr.josip.facebook.R

@Composable
fun Toolbar(title: String = stringResource(id = R.string.app_name)) {
    TopAppBar(
        elevation = 0.dp,
        backgroundColor = MaterialTheme.colors.primary,
        title = {
            Text(
                text = title,
                style = MaterialTheme.typography.h6,
                color = MaterialTheme.colors.onPrimary
            )
        }
    )
}