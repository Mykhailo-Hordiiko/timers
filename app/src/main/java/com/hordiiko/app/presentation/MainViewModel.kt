package com.hordiiko.app.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.hordiiko.core.screen.Screen
import com.hordiiko.core.screen.ScreenConfig
import com.hordiiko.core.screen.timersScreenConfig

class MainViewModel : ViewModel() {

    internal val startScreen: Screen = Screen.Timers
    private val startScreenConfig: ScreenConfig = timersScreenConfig()

    internal var screenConfig: ScreenConfig by mutableStateOf(startScreenConfig)
        private set

    internal fun updateScreenConfig(config: ScreenConfig) {
        screenConfig = config
    }
}