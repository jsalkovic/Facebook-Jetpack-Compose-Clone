@file:Suppress("LeakingThis")

package hr.josip.composeapp.ui.shared.base

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

abstract class BaseViewModel<ViewState> : ViewModel() {

    protected abstract fun provideDefaultState(): ViewState

    var viewState by mutableStateOf(provideDefaultState())

    var commonState by mutableStateOf<CommonState>(CommonState.Idle)

    protected fun showLoading() {
        commonState = CommonState.Loading
    }

    protected fun showIdle() {
        commonState = CommonState.Idle
    }

    protected fun showError(errorMessage: String = "") {
        commonState = CommonState.Error(errorMessage = errorMessage)
    }

    protected fun showEmpty(emptyMessage: String = "") {
        commonState = CommonState.Empty(emptyMessage = emptyMessage)
    }

}