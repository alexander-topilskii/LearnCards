package com.talex.learncards.components.messages

import android.content.res.Configuration
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.talex.learncards.viewmodel.Message


@Composable
fun MessageTitle(message: Message) {
    Text(
        text = message.title,
        color = MaterialTheme.colors.secondaryVariant
    )
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
fun PreviewMessageTitle() {
    MessageTitle(Message("PreviewMessageTitle", "some content"))
}