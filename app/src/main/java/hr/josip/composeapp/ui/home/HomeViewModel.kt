package hr.josip.composeapp.ui.home

import androidx.hilt.lifecycle.ViewModelInject
import hr.josip.composeapp.ui.shared.base.BaseViewModel

class HomeViewModel @ViewModelInject constructor(): BaseViewModel<HomeState>() {

    override fun provideDefaultState(): HomeState = HomeState()
}