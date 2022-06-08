package com.samsung.android.sclou

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor() : ViewModel() {
    var uiifwesbxwxuzmyste = MutableStateFlow<MainAcifwesbxwxuzmysEvent?>(null)
        private set
    var isifwesbxwxuzmysng by mutableStateOf(true)
    var route by mutableStateOf("")

    fun sendIifwesbxwxuzmyspEvent(send: Boolean? = true) {
        uiifwesbxwxuzmyste.value = if (send == true) MainAcifwesbxwxuzmysEvent.IifwesbxwxuzmysApp else null
    }

    sealed class MainAcifwesbxwxuzmysEvent {
        object IifwesbxwxuzmysApp : MainAcifwesbxwxuzmysEvent()
    }
}