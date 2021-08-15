package com.talex.learncards.components

import android.content.res.Configuration
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.talex.datasource.messageBody
import com.talex.learncards.viewmodel.Message


@Composable
fun MessageContent(message: Message, isExpanded: Boolean) {
    Surface(shape = MaterialTheme.shapes.medium, elevation = 1.dp) {
        Text(
            text = message.body,
            modifier = Modifier.padding(all = 4.dp),
            maxLines = if (isExpanded) Int.MAX_VALUE else 1,
            style = MaterialTheme.typography.body2
        )
    }
}

@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true,
    name = "Dark Mode"
)
@Preview(
    showBackground = true,
    name = "Light Mode"
)
@Composable
fun PreviewMessageContent() {
    MessageContent(Message("Alex", messageBody), true)
}

@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true,
    name = "Dark Mode"
)
@Preview(
    showBackground = true,
    name = "Light Mode"
)
@Composable
fun PreviewMessageContent2() {
    MessageContent(
        Message(
            "SomeText",
            messageBody
        ),
        false
    )
}