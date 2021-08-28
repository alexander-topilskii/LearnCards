package com.talex.learncards

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource

@Composable
fun BottomNavigationUi(bottomItems: List<MyScreen>) {
    BottomNavigation {
        bottomItems.forEach { screen ->
            val title = stringResource(id = screen.titleResourceId)
            BottomNavigationItem(
                selected = false,
                onClick = {
                    println("GGGG EnterActivity.onCreate $title ")
                },
                label = { Text(stringResource(id = screen.titleResourceId)) },
                icon = {
                    Icon(screen.icon, "$title", tint = Color.White)
                })
        }
    }
}