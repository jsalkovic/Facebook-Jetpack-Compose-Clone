package hr.josip.composeapp.ui.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.preferredSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import hr.josip.composeapp.ui.shared.compose.GlideImage

@Composable
fun CircleImage(
    width: Dp = 56.dp,
    height: Dp = 56.dp,
    padding: Dp = 4.dp,
    url: String,
) {
    GlideImage(
        model = url,
        modifier = Modifier.preferredSize(width = width, height = height).clip(CircleShape)
            .padding(padding)
    )
}

@Composable
fun CircleImageRes(
    width: Dp = 56.dp,
    height: Dp = 56.dp,
    padding: Dp = 4.dp,
    resId: Int) {
    Image(
        asset = imageResource(id = resId),
        modifier = Modifier.preferredSize(width = width, height = height)
            .padding(padding)
            .clip(CircleShape),
        contentScale = ContentScale.Crop
    )
}