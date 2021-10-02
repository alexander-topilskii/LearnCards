package com.talex.learncards

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun BottomNavigationUi(router: Router) {
    val bottomViewModel : BottomViewModel = viewModel()
    BottomNavigation {
        bottomViewModel.mainScreenData.value.forEach { screen ->
            val title = stringResource(id = screen.titleResourceId)
            BottomNavigationItem(
                selected = false,
                onClick = { router.routeTo(screen.screenName) },
                label = { Text(stringResource(id = screen.titleResourceId)) },
                icon = {
                    Icon(screen.icon, title, tint = Color.White)
                })
        }
    }
}

@Preview
@Composable
fun BottomNavigationPreview() {
    BottomNavigationUi(
        object : Router {},
    )
}