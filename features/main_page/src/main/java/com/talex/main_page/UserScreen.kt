package com.talex.main_page

import androidx.compose.material.Text
import androidx.compose.runtime.Composable

@Composable
fun UserScreen(
    model: UserModel
) {
    Text("User -> ${model.username}")
}