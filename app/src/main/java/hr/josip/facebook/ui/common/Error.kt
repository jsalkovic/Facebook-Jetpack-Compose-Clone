package hr.josip.facebook.ui.common

import androidx.compose.runtime.*
import androidx.compose.ui.res.stringResource
import hr.josip.facebook.R
import hr.josip.facebook.ui.shared.base.BaseViewModel

@Composable
fun Error(
    viewModel: BaseViewModel<*,*,*>,
    errorMessage: String = stringResource(id = R.string.error_message)
) {
    val (showDialog, setShowDialog) = remember { mutableStateOf(true) }
    AlertDialog(
        showDialog = showDialog,
        setShowDialog = setShowDialog,
        text = errorMessage,
        viewModel = viewModel
    )
}