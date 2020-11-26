package hr.josip.composeapp.ui.feed

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.viewModelScope
import hr.josip.composeapp.domain.UseCases
import hr.josip.composeapp.ui.shared.base.BaseViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class FeedViewModel @ViewModelInject constructor(private val getFeedUseCase: UseCases.GetFeedUseCase) :
    BaseViewModel<FeedState>() {

    override fun provideDefaultState(): FeedState = FeedState()

    fun getFeed() = viewModelScope.launch {
        showLoading()
        state =
            state.copy(feed = withContext(Dispatchers.IO) { getFeedUseCase.execute(Unit) })
        showIdle()
    }

}