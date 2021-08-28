package com.talex.learncards.viewmodel

import com.talex.datasource.Source
import com.talex.learncards.MyScreen
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class BlankViewModel : com.talex.ui.BaseViewModel() {
    private val source: Source = Source

    private val _enterScreenState = MutableStateFlow("text")
    val enterScreenState = _enterScreenState.asStateFlow()
    val mainScreenData = MutableStateFlow(listOf(MyScreen.Enter, MyScreen.Settings)).asStateFlow()


    init {
        launch {
            for (i in 0..20) {
                delay(1000)
                _enterScreenState.value = "new value $i"
                println("GGGG BlankViewModel.  $i")
            }
        }
    }
}


