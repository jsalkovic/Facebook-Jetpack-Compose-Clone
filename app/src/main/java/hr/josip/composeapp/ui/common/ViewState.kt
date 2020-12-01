package hr.josip.composeapp.ui.common

import androidx.compose.animation.Crossfade
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import hr.josip.composeapp.ui.shared.base.*

@Composable
fun <ViewState, ViewEvent> WithViewState(
    viewModel: BaseViewModel<ViewState, ViewEvent>,
    commonStateHolder: State<CommonState?> = viewModel.commonStateHolder().observeAsState(),
    viewStateHolder: State<ViewState?> = viewModel.viewStateHolder().observeAsState(),
    viewEventStateHolder: State<ViewEvent?> = viewModel.viewEventHolder().observeAsState(),
    viewStateChanged: (@Composable (ViewState) -> Unit),
    viewEventOccurred: (@Composable (ViewEvent) -> Unit)
) {
    commonStateHolder.value?.let { commonState ->
        Crossfade(current = commonState) {
            when (it) {
                CommonState.Loading -> Loading()
                is CommonState.Empty -> Empty(it.emptyMessage)
                is CommonState.Error -> Error(it.errorMessage)
                CommonState.Idle -> {
                    HandleViewState(viewStateHolder, viewStateChanged)
                    HandleViewEvent(viewEventStateHolder, viewEventOccurred)
                }
            }
        }

    }
}

@Composable
private fun <ViewState> HandleViewState(
    viewStateHolder: State<ViewState?>,
    viewStateChanged: (@Composable (ViewState) -> Unit)
) = viewStateHolder.value?.let { viewState -> viewStateChanged.invoke(viewState) }


@Composable
private fun <ViewEvent> HandleViewEvent(
    eventStateHolder: State<ViewEvent?>,
    eventStateChanged: (@Composable (ViewEvent) -> Unit)
) = eventStateHolder.value?.let { viewEvent -> eventStateChanged.invoke(viewEvent) }