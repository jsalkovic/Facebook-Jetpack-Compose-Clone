package hr.josip.composeapp.ui.common

import androidx.compose.runtime.*
import androidx.compose.ui.res.stringResource
import hr.josip.composeapp.R
import hr.josip.composeapp.ui.shared.base.BaseViewModel

@Composable
fun Error(
    viewModel: BaseViewModel<*, *>,
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