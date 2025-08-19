package com.hordiiko.feature.timers.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.hordiiko.core.navigation.Screen
import com.hordiiko.feature.timers.timer.presentation.TimersMainScreen

fun NavGraphBuilder.timersScreen() {
    composable(Screen.Timers.route) {
        TimersMainScreen()
    }
}