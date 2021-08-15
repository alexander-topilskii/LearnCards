package com.talex.learncards.viewmodel

import androidx.lifecycle.ViewModel
import com.talex.learncards.viewmodel.CoroutineImpl
import kotlinx.coroutines.CoroutineScope

open class BaseViewModel : ViewModel(), CoroutineScope by CoroutineImpl() {

}