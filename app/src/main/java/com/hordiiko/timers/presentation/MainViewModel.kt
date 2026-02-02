package com.hordiiko.timers.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.hordiiko.core.screen.ScreenConfig
import com.hordiiko.core.screen.timersConfig

class MainViewModel : ViewModel() {

    internal var screenConfig: ScreenConfig by mutableStateOf(timersConfig())
        private set

    internal fun updateScreenConfig(config: ScreenConfig) {
        screenConfig = config
    }
}