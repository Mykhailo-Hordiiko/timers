package com.hordiiko.feature.timers.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.hordiiko.core.navigation.Screen
import com.hordiiko.feature.timers.countdown.presentation.CountdownCreateScreen
import com.hordiiko.feature.timers.main.presentation.TimersMainScreen
import com.hordiiko.feature.timers.pomodoro.presentation.PomodoroCreateScreen
import com.hordiiko.feature.timers.stopwatch.presentation.StopwatchCreateScreen
import com.hordiiko.feature.timers.tabata.presentation.TabataCreateScreen

fun NavGraphBuilder.timersScreen() {
    composable(Screen.Timers.route) {
        TimersMainScreen()
    }

    composable(Screen.StopwatchCreate.route) {
        StopwatchCreateScreen()
    }
    composable(Screen.CountdownCreate.route) {
        CountdownCreateScreen()
    }
    composable(Screen.PomodoroCreate.route) {
        PomodoroCreateScreen()
    }
    composable(Screen.TabataCreate.route) {
        TabataCreateScreen()
    }
}