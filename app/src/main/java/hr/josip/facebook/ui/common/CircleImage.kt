package hr.josip.facebook.ui.common

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.bumptech.glide.request.RequestOptions

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