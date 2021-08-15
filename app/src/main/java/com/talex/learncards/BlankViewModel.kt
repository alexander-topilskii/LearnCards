package com.talex.learncards

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.talex.datasource.Source
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.transform
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

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
            body = "sur:$item",
        )
    }
}

data class Message(val title: String, val body: String)


open class BaseViewModel : ViewModel(), CoroutineScope by CoroutineImpl() {

}

suspend fun <T> Flow<T>.into(liveData: MutableLiveData<T>) = collect {
    liveData.postValue(it)
}


public inline fun <T, R> Flow<T>.convert(crossinline transform: suspend T.() -> R): Flow<R> = transform { value ->
    return@transform emit(value.transform())
}

// TODO: Extract me to common module
class CoroutineImpl : CoroutineScope {
    override val coroutineContext: CoroutineContext = Dispatchers.IO + SupervisorJob()
}