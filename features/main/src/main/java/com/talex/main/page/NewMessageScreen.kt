package com.talex.main.page

import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.talex.main.R

@Composable
fun NewMessageScreen() {
    Scaffold(
        topBar = {
            TopAppBar {
                Text(text = stringResource(id = R.string.title_message))
            }
        }
    ) {
        Text("Write new message here")
    }
}