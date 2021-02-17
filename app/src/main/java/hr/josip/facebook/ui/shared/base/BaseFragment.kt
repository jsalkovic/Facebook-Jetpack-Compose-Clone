package hr.josip.facebook.ui.shared.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import hr.josip.facebook.ui.common.HandleCommonState
import hr.josip.facebook.ui.common.WithViewEvent
import hr.josip.facebook.ui.common.WithViewState
import hr.josip.facebook.ui.shared.compose.ComposeAppTheme

abstract class BaseFragment<ViewState : Any, ViewEvent : Any> : Fragment() {

    protected abstract fun provideBaseViewModel(): BaseViewModel<ViewState, ViewEvent>?

    @Composable
    protected abstract fun HandleState(state: ViewState)

    @Composable
    protected abstract fun HandleEvent(event: ViewEvent)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? =
        ComposeView(requireContext()).apply {
            setContent {
                ComposeAppTheme {
                    provideBaseViewModel()?.let { viewModel ->
                        HandleCommonState(viewModel)
                        WithViewState(viewModel) { viewState -> HandleState(viewState) }
                        WithViewEvent(viewModel) { viewEvent -> HandleEvent(viewEvent) }
                    }
                }
            }
        }
}