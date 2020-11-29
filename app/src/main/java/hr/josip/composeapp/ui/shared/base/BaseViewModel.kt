@file:Suppress("LeakingThis")

package hr.josip.composeapp.ui.shared.base

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

abstract class BaseViewModel<ViewState, ViewEvent> : ViewModel() {

    //internal states
    var viewState by mutableStateOf<ViewState?>(null)
    var commonState by mutableStateOf<CommonState?>(null)
    var viewEvent by mutableStateOf<ViewEvent?>(null)
    //endregion

    //exposed observing states
    /*val viewStateHolder: State<ViewState?> = mutableStateOf(viewState)
    val commonStateHolder: State<CommonState?> = mutableStateOf(commonState)
    val viewEventHolder: State<ViewEvent?> = mutableStateOf(viewEvent)*/
    //endregion

    //common state methods
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
    //endregion

}