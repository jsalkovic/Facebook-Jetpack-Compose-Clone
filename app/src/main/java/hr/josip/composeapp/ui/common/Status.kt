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
                    model = R.drawable.user_avatar,
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