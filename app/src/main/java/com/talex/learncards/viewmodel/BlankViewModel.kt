package com.talex.learncards

import androidx.lifecycle.MutableLiveData
import com.talex.datasource.Source
import com.talex.datasource.messageBody
import com.talex.learncards.viewmodel.BaseViewModel
import com.talex.learncards.viewmodel.Message
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.transform
import kotlinx.coroutines.launch

class BlankViewModel() : BaseViewModel() {
    private val source: Source = Source

    val dataLiveData = MutableLiveData<List<Message>>().also { liveData ->
        launch {
            source.getFlowNumbers(50)
                .map(::toUiModel)
                .into(liveData)
        }
    }

    private fun toUiModel(list: List<Int>): List<Message> = list.mapIndexed { index, item ->
        Message(
            title = "index:$index",
            body = "$messageBody:$item",
        )
    }
}


suspend fun <T> Flow<T>.into(liveData: MutableLiveData<T>) = collect {
    liveData.postValue(it)
}


public inline fun <T, R> Flow<T>.convert(crossinline transform: suspend T.() -> R): Flow<R> = transform { value ->
    return@transform emit(value.transform())
}

