package com.hordiiko.app.presentation

import com.hordiiko.app.navigation.Navigator
import com.hordiiko.core.screen.Screen
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
            is TimerCreate -> performAction(action)
        }
    }

    private fun performAction(action: TimerCreate) {
        val screen: Screen =
            when (action) {
                TimerCreate.Stopwatch -> Screen.StopwatchCreate
                TimerCreate.Countdown -> Screen.CountdownCreate
                TimerCreate.Pomodoro -> Screen.PomodoroCreate
                TimerCreate.Tabata -> Screen.TabataCreate
            }

        navigator.navigateTo(screen)
    }
}