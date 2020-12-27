package hr.josip.facebook.ui.shared.base

sealed class CommonState {
    class Empty(val emptyMessage: String) : CommonState()
    class Error(val errorMessage: String) : CommonState()
    object Idle : CommonState()
    object Loading : CommonState()
}