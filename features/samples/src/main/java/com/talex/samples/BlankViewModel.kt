package com.talex.samples

import androidx.lifecycle.MutableLiveData
import com.talex.datasource.Source
import com.talex.datasource.messageBody
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

class BlankViewModel : com.talex.ui.BaseViewModel() {

    val dataLiveData = MutableLiveData<List<Message>>().also { liveData ->
        launch {
//            Source.getFlowNumbers(1000)
//                .map(::toUiModel)
//                .into(liveData)
        }
    }

    private fun toUiModel(list: List<Int>): List<Message> = list.mapIndexed { index, item ->
        Message(
            title = "index:$index",
            body = "$messageBody:$item",
        )
    }
}