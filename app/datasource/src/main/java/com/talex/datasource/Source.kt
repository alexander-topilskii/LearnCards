package com.talex.datasource

import kotlinx.coroutines.currentCoroutineContext
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.isActive
import javax.inject.Inject

class Source @Inject constructor() {

    fun getNumbers(count: Int = 100): List<Int> = (0..count).shuffled()

    fun getFlowNumber(count: Int = 100): Flow<Int> {
        return flow {
            (0..count).shuffled().forEach {
                emit(it)
                delay(200)
            }
        }
    }

    fun getFlowNumbers(count: Int = 100): Flow<List<Int>> {
        return flow {
            emit((0..count).shuffled())
        }
    }

    fun getChangeableFlowNumbers(count: Int = 100, delay: Long = 3000L): Flow<List<Int>> {
        return flow {
            while (currentCoroutineContext().isActive) {
                emit((0..count).shuffled())
                delay(delay)
            }
        }
    }

}