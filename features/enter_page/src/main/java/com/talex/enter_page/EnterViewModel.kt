package com.talex.enter_page

import com.talex.learncards.MyScreen
import com.talex.ui.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class EnterViewModel @Inject constructor() : BaseViewModel() {

    private val _enterScreenState = MutableStateFlow("text")
    val enterScreenState = _enterScreenState.asStateFlow()
    private val value = listOf(MyScreen.Enter, MyScreen.Settings)
    val mainScreenData = MutableStateFlow(value).asStateFlow()

    init {
        println("GGGG EnterViewModel.init")
        launch {
            for (i in 0..20) {
                delay(1000)
                _enterScreenState.value = "new value $i"
            }
        }
    }
}