package com.hordiiko.feature.timers.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.hordiiko.core.screen.Screen
import com.hordiiko.core.screen.ScreenAction
import com.hordiiko.core.screen.ScreenConfig
import com.hordiiko.feature.timers.countdown.presentation.CountdownCreateScreen
import com.hordiiko.feature.timers.main.presentation.TimersScreen
import com.hordiiko.feature.timers.pomodoro.presentation.PomodoroCreateScreen
import com.hordiiko.feature.timers.stopwatch.presentation.StopwatchCreateScreen
import com.hordiiko.feature.timers.tabata.presentation.TabataCreateScreen

fun NavGraphBuilder.timersNavGraph(
    updateScreenConfig: (ScreenConfig) -> Unit,
    performScreenAction: (ScreenAction) -> Unit
) {
    composable(Screen.Timers.route) {
        TimersScreen(
            updateScreenConfig = updateScreenConfig,
            performScreenAction = performScreenAction
        )
    }

    composable(Screen.StopwatchCreate.route) {
        StopwatchCreateScreen(
            updateScreenConfig = updateScreenConfig,
            performScreenAction = performScreenAction
        )
    }
    composable(Screen.CountdownCreate.route) {
        CountdownCreateScreen(
            updateScreenConfig = updateScreenConfig,
            performScreenAction = performScreenAction
        )
    }
    composable(Screen.PomodoroCreate.route) {
        PomodoroCreateScreen(
            updateScreenConfig = updateScreenConfig,
            performScreenAction = performScreenAction
        )
    }
    composable(Screen.TabataCreate.route) {
        TabataCreateScreen(
            updateScreenConfig = updateScreenConfig,
            performScreenAction = performScreenAction
        )
    }
}