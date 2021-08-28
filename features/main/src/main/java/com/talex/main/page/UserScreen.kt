package com.talex.main.page

import androidx.compose.material.Text
import androidx.compose.runtime.Composable

@Composable
fun UserScreen(
    model: UserModel
) {
    Text("User -> ${model.username}")
}