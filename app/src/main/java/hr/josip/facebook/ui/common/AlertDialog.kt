package hr.josip.facebook.ui.common

import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.res.stringResource
import hr.josip.facebook.R
import hr.josip.facebook.ui.shared.base.BaseViewModel

@Composable
fun AlertDialog(
    showDialog: Boolean = remember { false },
    setShowDialog: (Boolean) -> Unit,
    title: String = stringResource(id = R.string.app_name),
    text: String,
    confirmButtonText: String = stringResource(id = R.string.confirm_button_text),
    onConfirmClicked: (() -> Unit)? = null,
    viewModel: BaseViewModel<*,*>
) {
    if (showDialog) {
        AlertDialog(
            onDismissRequest = {
                setShowDialog(false)
                viewModel.clearCommonState()
            },
            title = {
                Text(
                    text = title,
                    color = MaterialTheme.colors.onSurface
                )
            },
            text = {
                Text(
                    text = text,
                    color = MaterialTheme.colors.onSurface
                )
            },
            confirmButton = {
                TextButton(onClick = {
                    setShowDialog(false)
                    onConfirmClicked?.invoke()
                    viewModel.clearCommonState()
                }) {
                    Text(
                        text = confirmButtonText,
                        color = MaterialTheme.colors.onSurface
                    )
                }
            }
        )
    }
}

