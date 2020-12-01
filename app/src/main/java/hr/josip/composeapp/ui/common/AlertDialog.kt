package hr.josip.composeapp.ui.common

import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.res.stringResource
import hr.josip.composeapp.R

@Composable
fun AlertDialog(
    title: String = stringResource(id = R.string.app_name),
    text: String,
    confirmButtonText: String = stringResource(id = R.string.confirm_button_text),
    onConfirmClicked: (() -> Unit)? = null,
    dismissButtonText: String = stringResource(id = R.string.dismiss_button_text),
    onDismissClicked: (() -> Unit)? = null
) {
    val isDialogShowing = remember { mutableStateOf(true) }
    if (isDialogShowing.value) {
        AlertDialog(
            onDismissRequest = { isDialogShowing.value = false },
            title = {
                Text(text = title)
            },
            text = {
                Text(text = text)
            },
            confirmButton = {
                TextButton(onClick = {
                    isDialogShowing.value = false
                    onConfirmClicked?.invoke()
                }) {
                    Text(text = confirmButtonText)
                }
            },
            dismissButton = {
                TextButton(onClick = {
                    isDialogShowing.value = false
                    onDismissClicked?.invoke()
                }) {
                    Text(text = dismissButtonText)
                }
            }
        )
    }
}

