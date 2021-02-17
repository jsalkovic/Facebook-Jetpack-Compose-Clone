package hr.josip.facebook.ui.common

import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import hr.josip.facebook.ui.shared.base.*

@Composable
fun <ViewState, ViewEvent> HandleCommonState(
    viewModel: BaseViewModel<ViewState, ViewEvent>,
    loadingView: (@Composable () -> Unit) = { Loading() },
    errorView: (@Composable (BaseViewModel<*, *>, String) -> Unit) = { baseViewModel, errorMessage ->
        Error(
            baseViewModel,
            errorMessage
        )
    },
    emptyView: (@Composable (String) -> Unit) = { emptyMessage -> Empty(emptyMessage) },
) = viewModel.commonStateHolder().observeAsState().also { commonStateHolder ->
    commonStateHolder.value?.let { commonState ->
        when (commonState) {
            CommonState.Loading -> loadingView.invoke()
            is CommonState.Empty -> emptyView.invoke(commonState.emptyMessage)
            is CommonState.Error -> errorView.invoke(viewModel, commonState.errorMessage)
        }
    }
}

@Composable
fun <ViewState, ViewEvent> WithViewState(
    viewModel: BaseViewModel<ViewState, ViewEvent>,
    viewStateChanged: (@Composable (ViewState) -> Unit)
) = viewModel.viewStateHolder().observeAsState().also { viewStateHolder ->
    viewStateHolder.value?.let { viewState -> viewStateChanged.invoke(viewState) }
}


@Composable
fun <ViewState, ViewEvent> WithViewEvent(
    viewModel: BaseViewModel<ViewState, ViewEvent>,
    eventStateChanged: (@Composable (ViewEvent) -> Unit)
) = viewModel.viewEventHolder().observeAsState().also { viewEventHolder ->
    viewEventHolder.value?.let { viewEvent -> eventStateChanged.invoke(viewEvent) }
}