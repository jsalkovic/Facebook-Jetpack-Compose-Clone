package hr.josip.composeapp.ui.common

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.preferredSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.bumptech.glide.request.RequestOptions
import hr.josip.composeapp.ui.shared.compose.GlideImage

@Composable
fun CircleImage(
    width: Dp = 56.dp,
    height: Dp = 56.dp,
    padding: Dp = 4.dp,
    model: Any,
) {
    GlideImage(
        model = model,
        modifier = Modifier.preferredSize(width = width, height = height).clip(CircleShape)
            .padding(padding),
        requestOptions = RequestOptions().circleCrop()
    )
}