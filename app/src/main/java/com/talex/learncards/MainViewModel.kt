package com.talex.learncards

import com.talex.ui.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor() : BaseViewModel() {

    private val value = listOf(MyScreen.Enter, MyScreen.Settings)
    val mainScreenData = MutableStateFlow(value).asStateFlow()

}