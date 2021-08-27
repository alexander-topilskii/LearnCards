package com.talex.main.page

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import com.talex.main.page.UserModel

@Composable
fun UserScreen(
    model: UserModel
) {
    Text("User -> ${model.username}")
}