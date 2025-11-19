package com.hordiiko.feature.timers.main.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.hordiiko.core.timers.TimerType

class TimersViewModel : ViewModel() {

    var selectedType: TimerType by mutableStateOf(TimerType.Stopwatch)
        private set

    fun selectType(type: TimerType) {
        selectedType = type
    }
}