package hr.josip.facebook.ui.common

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import hr.josip.facebook.R
import hr.josip.facebook.data.common.User
import hr.josip.facebook.ui.shared.compose.blue

@Composable
fun Input(user: User, hintLabel: String, onSendClick: (String) -> Unit) {
    Surface(modifier = Modifier.fillMaxWidth(), color = MaterialTheme.colors.surface) {
        Row(
            modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            UserPicture(user)
            Card(
                modifier = Modifier.fillMaxWidth().padding(horizontal = 8.dp, vertical = 8.dp),
                backgroundColor = MaterialTheme.colors.secondary,
                elevation = 0.dp
            ) {
                InputField(hintLabel, onSendClick)
            }
        }
    }
}

@Composable
private fun InputField(hintLabel: String, onSendClick: (String) -> Unit) {
    var text by remember { mutableStateOf("") }
    var sendButtonEnabled by remember { mutableStateOf(false) }
    TextField(
        value = text,
        textStyle = TextStyle(color = blue),
        onValueChange = { changedText ->
            text = changedText
            sendButtonEnabled = changedText.isNotEmpty()
        },
        modifier = Modifier.fillMaxWidth().height(56.dp),
        inactiveColor = MaterialTheme.colors.onPrimary,
        activeColor = blue,
        backgroundColor = Color.Transparent,
        label = {
            Text(
                text = hintLabel,
                color = blue
            )
        },
        singleLine = true,
        trailingIcon = {
            IconButton(
                modifier = Modifier.preferredSize(24.dp),
                content = {
                    Icon(
                        vectorResource(id = R.drawable.ic_send),
                        contentDescription = stringResource(id = R.string.app_name),
                        tint = if (sendButtonEnabled) blue else MaterialTheme.colors.onSurface
                    )
                },
                enabled = sendButtonEnabled,
                onClick = {
                    if (text.isNotEmpty()) {
                        onSendClick.invoke(text)
                        text = ""
                        sendButtonEnabled = false
                    }
                }
            )
        }
    )
}