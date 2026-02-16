package com.hordiiko.timers.presentation

import androidx.navigation.NavHostController
import com.hordiiko.core.navigation.navigateTo
import com.hordiiko.core.screen.Screen
import com.hordiiko.core.screen.ScreenAction
import com.hordiiko.core.screen.ScreenConfig
import com.hordiiko.core.screen.ScreenController

class MainScreenController(
    private val navController: NavHostController,
    private val updateScreenConfig: (ScreenConfig) -> Unit
) : ScreenController {

    override fun updateConfig(config: ScreenConfig) {
        updateScreenConfig(config)
    }

    override fun performAction(action: ScreenAction) {
        when (action) {
            ScreenAction.GoBack ->
                navController.popBackStack()

            ScreenAction.OpenStopwatchCreate ->
                navController.navigateTo(Screen.StopwatchCreate)

            ScreenAction.OpenCountdownCreate ->
                navController.navigateTo(Screen.CountdownCreate)

            ScreenAction.OpenPomodoroCreate ->
                navController.navigateTo(Screen.PomodoroCreate)

            ScreenAction.OpenTabataCreate ->
                navController.navigateTo(Screen.TabataCreate)
        }
    }
}