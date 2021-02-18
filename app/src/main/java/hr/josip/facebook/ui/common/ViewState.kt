package hr.josip.facebook.ui.common

import android.annotation.SuppressLint
import androidx.compose.runtime.*
import hr.josip.facebook.ui.shared.base.*
import timber.log.Timber

@SuppressLint("ComposableNaming")
@Composable
fun <ViewState, ViewEvent, ViewEffect> HandleCommonState(
    viewModel: BaseViewModel<ViewState, ViewEvent, ViewEffect>,
    loadingView: (@Composable () -> Unit) = { Loading() },
    errorView: (@Composable (BaseViewModel<*,*,*>, String) -> Unit) = { baseViewModel, errorMessage ->
        Error(
            baseViewModel,
            errorMessage
        )
    },
    emptyView: (@Composable (String) -> Unit) = { emptyMessage -> Empty(emptyMessage) },
) = viewModel.commonState().also { commonStateHolder ->
    commonStateHolder.value.let { commonState ->
        Timber.i("HandleCommonState($commonState) called!")
        when (commonState) {
            CommonState.Loading -> loadingView.invoke()
            is CommonState.Empty -> emptyView.invoke(commonState.emptyMessage)
            is CommonState.Error -> errorView.invoke(viewModel, commonState.errorMessage)
            CommonState.Idle -> Unit
        }
    }
}

@SuppressLint("ComposableNaming")
@Composable
fun <ViewState, ViewEvent, ViewEffect> WithViewState(
    viewModel: BaseViewModel<ViewState, ViewEvent, ViewEffect>,
    viewStateChanged: (@Composable (ViewState) -> Unit)
) = viewModel.viewState().also { viewStateHolder ->
    viewStateHolder.value?.let { viewState -> viewStateChanged.invoke(viewState) }
}

@SuppressLint("ComposableNaming")
@Composable
fun <ViewState, ViewEvent, ViewEffect> WithViewEffect(
    viewModel: BaseViewModel<ViewState, ViewEvent, ViewEffect>,
    effectStateChanged: (@Composable (ViewEffect) -> Unit)
) = viewModel.viewEffect().also { viewEffectHolder ->
    viewEffectHolder.value?.let { viewEffect -> effectStateChanged.invoke(viewEffect) }
}
