package hr.josip.composeapp.ui.common

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import hr.josip.composeapp.R
import hr.josip.composeapp.ui.shared.compose.blue

@Composable
fun Status(onSendClick: (String) -> Unit) {
    Surface(modifier = Modifier.fillMaxWidth(), color = MaterialTheme.colors.surface) {
        Row(
            modifier = Modifier.padding(horizontal = 8.dp, vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Card(
                modifier = Modifier.preferredSize(56.dp).padding(8.dp),
                shape = CircleShape,
                elevation = 0.dp
            ) {
                CircleImage(
                    model = "https://scontent.fzag1-1.fna.fbcdn.net/v/t1.0-9/33527158_1008398122653200_5486756463634284544_o.jpg?_nc_cat=111&ccb=2&_nc_sid=09cbfe&_nc_ohc=7k8pQnnw8R4AX91cLBX&_nc_ht=scontent.fzag1-1.fna&oh=30dfbb76dc9abbd5b4a7d204d17875cc&oe=600C2803",
                    modifier = Modifier.preferredSize(width = 56.dp, height = 56.dp).padding(0.dp)
                )
            }
            Card(
                modifier = Modifier.fillMaxWidth().padding(horizontal = 8.dp, vertical = 8.dp),
                backgroundColor = MaterialTheme.colors.secondary,
                elevation = 0.dp
            ) {
                StatusInput(onSendClick)
            }
        }
    }
}

@Composable
private fun StatusInput(onSendClick: (String) -> Unit) {
    var text by remember { mutableStateOf("") }
    var sendButtonEnabled by remember { mutableStateOf(false) }
    var error by remember { mutableStateOf(false) }
    TextField(
        value = text,
        textStyle = TextStyle(color = blue),
        onValueChange = { changedText ->
            run {
                text = changedText
                sendButtonEnabled = changedText.isNotEmpty()
                error = changedText.isEmpty()
            }
        },
        modifier = Modifier.fillMaxWidth().preferredHeight(56.dp),
        inactiveColor = MaterialTheme.colors.onPrimary,
        activeColor = blue,
        backgroundColor = Color.Transparent,
        label = {
            Text(
                text = stringResource(id = R.string.status_hint),
                color = blue
            )
        },
        isErrorValue = error,
        trailingIcon = {
            IconButton(
                content = {
                    Icon(
                        vectorResource(id = R.drawable.ic_send),
                        tint = if (sendButtonEnabled) blue else MaterialTheme.colors.onSurface
                    )
                },
                enabled = sendButtonEnabled,
                onClick = {
                    if (text.isNotEmpty()) {
                        onSendClick.invoke(text)
                        text = ""
                    } else {
                        error = true
                    }
                }
            )
        }
    )
}