package com.talex.learncards.components.messages

import android.content.res.Configuration
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.talex.learncards.viewmodel.Message
import com.talex.learncards.ui.theme.LearnCardsTheme

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
fun PreviewMakeUI() {
    MakeUI(
        listOf(
            Message("Alex1", "Hello world1"),
            Message("Alex2", "Hello world2"),
            Message("Alex3", "Hello world3"),
            Message("Alex4", "Hello world4")
        )
    )
}


@Composable
fun MakeUI(messages: List<Message>) {
    LearnCardsTheme {
        Conversation(messages)
    }
}