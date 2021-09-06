package com.talex.settings

import androidx.navigation.NavHostController
import com.talex.datasource.Source
import com.talex.learncards.MyScreen
import com.talex.learncards.Router
import com.talex.ui.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SettingsViewModel @Inject constructor() : BaseViewModel() {

    private val _enterScreenState = MutableStateFlow("text")
    val enterScreenState = _enterScreenState.asStateFlow()
    private val value = listOf(MyScreen.Enter, MyScreen.Settings)
    val mainScreenData = MutableStateFlow(value).asStateFlow()

    init {
        launch {
            for (i in 0..20) {
                delay(1000)
                _enterScreenState.value = "new value $i"
            }
        }
    }
}