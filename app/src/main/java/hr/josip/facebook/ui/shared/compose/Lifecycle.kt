package hr.josip.facebook.ui.shared.compose

import androidx.compose.runtime.*
import hr.josip.facebook.ui.shared.base.BaseViewModel

@Composable
fun OnDispose(
    baseViewModel: BaseViewModel<*, *, *>?,
    disposeCallback: (() -> Unit)? = null
) = DisposableEffect(Unit) {
    onDispose {
        baseViewModel?.apply {
            clearCommonState()
            clearViewEffect()
        }
        disposeCallback?.invoke()
    }
}

@Composable
fun OnActive(activeCallback: (() -> Unit)? = null) =
    DisposableEffect(Unit) {
        ActiveDisposable(activeCallback)
    }

@Composable
fun OnCommit(commitCallback: () -> Unit) =
    SideEffect {
        commitCallback.invoke()
    }

private class ActiveDisposable(activeCallback: (() -> Unit)?) : DisposableEffectDisposable {

    init {
        activeCallback?.invoke()
    }

    override fun dispose() = Unit
}
