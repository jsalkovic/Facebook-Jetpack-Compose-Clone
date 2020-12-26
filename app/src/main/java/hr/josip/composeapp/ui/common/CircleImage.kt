package hr.josip.composeapp.ui.common

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.bumptech.glide.request.RequestOptions
import hr.josip.composeapp.ui.shared.compose.GlideImage

@Composable
fun CircleImage(
    modifier: Modifier,
    model: Any,

) {
    GlideImage(
        model = model,
        modifier = modifier,
        requestOptions = RequestOptions().circleCrop()
    )
}