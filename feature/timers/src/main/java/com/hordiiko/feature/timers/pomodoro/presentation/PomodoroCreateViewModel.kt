package com.hordiiko.feature.timers.pomodoro.presentation

import androidx.lifecycle.ViewModel
import com.hordiiko.core.screen.ScreenAction

class PomodoroCreateViewModel : ViewModel() {

    internal fun onBackButtonClick(): ScreenAction = ScreenAction.GoBack

    internal fun onConfirmButtonClick(): ScreenAction = ScreenAction.GoBack
}