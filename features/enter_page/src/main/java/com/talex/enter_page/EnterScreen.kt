package com.talex.enter_page

import androidx.compose.foundation.layout.Row
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import com.talex.ui.stateValue

@Composable
fun EnterScreen(enterViewModel: EnterViewModel) {
    Row {
        Button(onClick = {

        }
        ) {
            Text(enterViewModel.enterScreenState.stateValue())
        }
    }
}