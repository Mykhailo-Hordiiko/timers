package com.hordiiko.feature.timers.stopwatch.presentation

import androidx.lifecycle.ViewModel
import com.hordiiko.core.screen.ScreenAction

class StopwatchCreateViewModel : ViewModel() {

    internal fun onBackButtonClick(): ScreenAction = ScreenAction.GoBack

    internal fun onConfirmButtonClick(): ScreenAction = ScreenAction.GoBack
}