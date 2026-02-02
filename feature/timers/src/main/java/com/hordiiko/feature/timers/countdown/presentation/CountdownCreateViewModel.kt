package com.hordiiko.feature.timers.countdown.presentation

import androidx.lifecycle.ViewModel
import com.hordiiko.core.screen.ScreenAction

class CountdownCreateViewModel : ViewModel() {

    internal fun onBackButtonClick(): ScreenAction = ScreenAction.GoBack

    internal fun onConfirmButtonClick(): ScreenAction = ScreenAction.GoBack
}