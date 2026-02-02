package com.hordiiko.feature.timers.main.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.hordiiko.core.screen.ScreenAction
import com.hordiiko.core.timers.TimerType

class TimersViewModel : ViewModel() {

    internal var timerType: TimerType by mutableStateOf(TimerType.Stopwatch)
        private set

    internal fun selectTimerType(type: TimerType) {
        if (timerType != type) {
            timerType = type
        }
    }

    internal fun onFabClick(): ScreenAction = when (timerType) {
        TimerType.Stopwatch -> ScreenAction.OpenStopwatchCreate
        TimerType.Countdown -> ScreenAction.OpenCountdownCreate
        TimerType.Pomodoro -> ScreenAction.OpenPomodoroCreate
        TimerType.Tabata -> ScreenAction.OpenTabataCreate
    }
}