package com.hordiiko.feature.timers.tabata.presentation

import androidx.lifecycle.ViewModel
import com.hordiiko.core.screen.ScreenAction

class TabataCreateViewModel : ViewModel() {

    internal fun onBackButtonClick(): ScreenAction = ScreenAction.GoBack

    internal fun onConfirmButtonClick(): ScreenAction = ScreenAction.GoBack
}