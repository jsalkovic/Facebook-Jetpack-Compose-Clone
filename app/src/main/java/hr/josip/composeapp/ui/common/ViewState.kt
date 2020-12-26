package hr.josip.composeapp.ui.common

import androidx.compose.animation.Crossfade
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import hr.josip.composeapp.ui.shared.base.*

@Composable
fun <ViewState, ViewEvent> HandleCommonState(
    viewModel: BaseViewModel<ViewState, ViewEvent>,
    commonStateHolder: State<CommonState?> = viewModel.commonStateHolder().observeAsState(),
) {
    commonStateHolder.value?.let { commonState ->
        Crossfade(current = commonState) {
            when (it) {
                CommonState.Loading -> Loading(true)
                is CommonState.Empty -> Empty(it.emptyMessage)
                is CommonState.Error -> Error(it.errorMessage)
                CommonState.Idle -> Loading(false)
            }
        }
    }
}

@Composable
fun <ViewState, ViewEvent> HandleViewState(
    viewModel: BaseViewModel<ViewState, ViewEvent>,
    viewStateHolder: State<ViewState?> = viewModel.viewStateHolder().observeAsState(),
    viewStateChanged: (@Composable (ViewState) -> Unit)
) {
    viewStateHolder.value?.let { viewState -> viewStateChanged.invoke(viewState) }
}


@Composable
fun <ViewState, ViewEvent> HandleViewEvent(
    viewModel: BaseViewModel<ViewState, ViewEvent>,
    eventStateHolder: State<ViewEvent?> = viewModel.viewEventHolder().observeAsState(),
    eventStateChanged: (@Composable (ViewEvent) -> Unit)
) {
    eventStateHolder.value?.let { viewEvent -> eventStateChanged.invoke(viewEvent) }
}