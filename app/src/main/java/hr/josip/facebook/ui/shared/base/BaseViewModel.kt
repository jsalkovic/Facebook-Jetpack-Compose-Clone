package hr.josip.facebook.ui.shared.base

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

abstract class BaseViewModel<ViewState, ViewEvent>(application: Application) : AndroidViewModel(
    application
) {

    // private live dates
    private val viewStateLiveData: MutableLiveData<ViewState> = MutableLiveData()
    private val commonStateLiveData: MutableLiveData<CommonState> = MutableLiveData()
    private val viewEventLiveData: LiveEvent<ViewEvent> = LiveEvent()
    //endregion

    // exposed observable states and events
    fun viewStateHolder(): LiveData<ViewState> = viewStateLiveData
    fun commonStateHolder(): LiveData<CommonState> = commonStateLiveData
    fun viewEventHolder(): LiveData<ViewEvent> = viewEventLiveData
    //endregion

    // internal states
    protected var viewState: ViewState?
        get() = viewStateLiveData.value
        set(value) {
            viewStateLiveData.value = value
        }

    private var commonState: CommonState?
        get() = commonStateLiveData.value
        set(value) {
            commonStateLiveData.value = value
        }

    protected fun emitViewEvent(viewEvent: ViewEvent) {
        viewEventLiveData.value = viewEvent
    }

    //common state methods
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
        commonState = null
    }
    //endregion

}