package com.hordiiko.feature.timers.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.hordiiko.core.screen.Screen
import com.hordiiko.core.screen.ScreenController
import com.hordiiko.feature.timers.countdown.presentation.CountdownCreateScreen
import com.hordiiko.feature.timers.main.presentation.TimersScreen
import com.hordiiko.feature.timers.pomodoro.presentation.PomodoroCreateScreen
import com.hordiiko.feature.timers.stopwatch.presentation.StopwatchCreateScreen
import com.hordiiko.feature.timers.tabata.presentation.TabataCreateScreen

fun NavGraphBuilder.timersNavGraph(screenController: ScreenController) {
    composable(Screen.Timers.route) { TimersScreen(screenController) }

    composable(Screen.StopwatchCreate.route) { StopwatchCreateScreen(screenController) }
    composable(Screen.CountdownCreate.route) { CountdownCreateScreen(screenController) }
    composable(Screen.PomodoroCreate.route) { PomodoroCreateScreen(screenController) }
    composable(Screen.TabataCreate.route) { TabataCreateScreen(screenController) }
}