package hr.josip.facebook.ui.shared.base

import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.livedata.observeAsState
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

abstract class BaseViewModel<ViewState, ViewEvent, ViewEffect> : ViewModel() {

    // common state
    private val _commonState = MutableLiveData<CommonState?>()

    @Composable
    fun commonState(): State<CommonState?> = _commonState.observeAsState()

    private var commonState: CommonState?
        get() = _commonState.value
        set(value) {
            _commonState.value = value
        }

    protected fun showLoading() {
        commonState = CommonState.Loading
    }

    protected fun showError(errorMessage: String = "") {
        commonState = CommonState.Error(errorMessage = errorMessage)
    }

    protected fun showEmpty(emptyMessage: String = "") {
        commonState = CommonState.Empty(emptyMessage = emptyMessage)
    }

    fun clearCommonState(){
        commonState = CommonState.Idle
    }
    //endregion

    // view state

    private val _viewState = MutableLiveData<ViewState?>()

    @Composable
    fun viewState(): State<ViewState?> = _viewState.observeAsState()

    protected var viewState: ViewState?
        get() = _viewState.value
        set(value) {
            _viewState.value = value
        }
    //endregion

    // view event
    fun intent(event: ViewEvent) = handleIntent(event)

    protected abstract fun handleIntent(event: ViewEvent)
    //endregion

    // view effect
    private val _viewEffect = LiveEffect<ViewEffect?>()

    @Composable
    fun viewEffect() = _viewEffect.observeAsState()

    protected fun emitEffect(viewEffect: ViewEffect) {
        _viewEffect.value = viewEffect
    }

    fun clearViewEffect(){
        _viewEffect.value = null
    }
    //endregion
}