package hr.josip.composeapp.ui.common

import androidx.compose.runtime.Composable
import hr.josip.composeapp.ui.shared.base.*

@Composable
fun <ViewState, ViewEvent> WithViewState(
    viewModel: BaseViewModel<ViewState, ViewEvent>,
    commonStateHolder: CommonState? = viewModel.commonState,
    viewState: ViewState? = viewModel.viewState,
    eventState: ViewEvent? = viewModel.viewEvent,
    viewStateChanged: (@Composable (ViewState) -> Unit),
    eventStateChanged: (@Composable (ViewEvent) -> Unit)
) {
    commonStateHolder.let { commonState ->
        when (commonState) {
            CommonState.Loading -> Loading()
            is CommonState.Empty -> Empty(commonState.emptyMessage)
            is CommonState.Error -> Error(commonState.errorMessage)
            CommonState.Idle -> {
                HandleViewState(viewState, viewStateChanged)
                HandleViewEvent(eventState, eventStateChanged)
            }
            else -> Unit
        }
    }

}

@Composable
private fun <ViewState> HandleViewState(
    viewState: ViewState?,
    viewStateChanged: (@Composable (ViewState) -> Unit)
) =
    viewState?.let { state -> viewStateChanged.invoke(state) }

@Composable
private fun <ViewEvent> HandleViewEvent(
    eventState: ViewEvent?,
    eventStateChanged: (@Composable (ViewEvent) -> Unit)
) =
    eventState?.let { event -> eventStateChanged.invoke(event) }