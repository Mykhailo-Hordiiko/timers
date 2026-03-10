package com.hordiiko.app.presentation

import com.hordiiko.app.navigation.Navigator
import com.hordiiko.core.screen.ScreenAction
import com.hordiiko.core.screen.ScreenAction.TimerCreate
import com.hordiiko.core.screen.ScreenConfig
import com.hordiiko.core.screen.ScreenController

internal class MainScreenController(
    private val navigator: Navigator,
    private val updateScreenConfig: (ScreenConfig) -> Unit
) : ScreenController {

    override fun updateConfig(config: ScreenConfig) {
        updateScreenConfig(config)
    }

    override fun performAction(action: ScreenAction) {
        when (action) {
            ScreenAction.GoBack -> navigator.goBack()
            is TimerCreate -> navigator.navigateTo(action.screen)
        }
    }
}