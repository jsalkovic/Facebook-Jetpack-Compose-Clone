package hr.josip.composeapp.ui.common

import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.res.stringResource

import hr.josip.composeapp.R

@Composable
fun AlertDialog(
    showDialog: Boolean,
    setShowDialog: (Boolean) -> Unit,
    title: String = stringResource(id = R.string.app_name),
    text: String,
    confirmButtonText: String = stringResource(id = R.string.confirm_button_text),
    onConfirmClicked: (() -> Unit)? = null,
    dismissButtonText: String = stringResource(id = R.string.dismiss_button_text),
    onDismissClicked: (() -> Unit)? = null
) {
    if (showDialog) {
        AlertDialog(
            onDismissRequest = { setShowDialog(false) },
            title = {
                Text(text = title)
            },
            text = {
                Text(text = text)
            },
            confirmButton = {
                TextButton(onClick = {
                    setShowDialog(false)
                    onConfirmClicked?.invoke()
                }) {
                    Text(text = confirmButtonText)
                }
            },
            dismissButton = {
                TextButton(onClick = {
                    setShowDialog(false)
                    onDismissClicked?.invoke()
                }) {
                    Text(text = dismissButtonText)
                }
            }
        )
    }
}

