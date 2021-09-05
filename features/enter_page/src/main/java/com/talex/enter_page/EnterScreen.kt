package com.talex.enter_page

import androidx.compose.foundation.layout.Row
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import com.talex.learncards.BottomNavigationUi
import com.talex.learncards.Router
import com.talex.ui.stateValue

@Composable
fun EnterScreen(router: Router, enterViewModel: EnterViewModel = viewModel()) {
    enterViewModel.addEnterScreenRouter(router)

    Scaffold(
        bottomBar = { BottomNavigationUi(enterViewModel.mainScreenData.stateValue()) }
    ) {
        Row {
            Button(onClick = {
                enterViewModel.onEnterScreenButtOnClicked()
            }) {
                Text(enterViewModel.enterScreenState.stateValue())
            }
        }
    }
}