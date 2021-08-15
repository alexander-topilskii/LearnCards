package com.talex.learncards.components

import android.content.res.Configuration
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.talex.learncards.components.messages.MessageCard
import com.talex.learncards.viewmodel.Message


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
fun PreviewConversation() {
    Conversation(
        listOf(
            Message("Alex1", "Hello world1"),
            Message("Alex2", "Hello world2"),
            Message("Alex3", "Hello world3"),
            Message("Alex4", "Hello world4")
        )
    )
}

@Composable
fun Conversation(messages: List<Message>) {
    LazyColumn {
        this.items(messages) { message ->
            MessageCard(message)
        }
    }
}
