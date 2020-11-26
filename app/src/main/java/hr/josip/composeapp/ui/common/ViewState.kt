package hr.josip.composeapp.ui.common

import androidx.compose.runtime.Composable
import hr.josip.composeapp.ui.shared.base.*

@Composable
fun <T> WithViewState(
    viewModel: BaseViewModel<T>,
    commonState: CommonState = viewModel.commonState,
    viewState: T = viewModel.viewState,
    onChanged: (@Composable (T) -> Unit)
) {
    when (commonState) {
        CommonState.Loading -> Loading()
        is CommonState.Empty -> Empty(commonState.emptyMessage)
        is CommonState.Error -> Error(commonState.errorMessage)
        CommonState.Idle -> viewState.also { value -> onChanged.invoke(value) }
    }
}