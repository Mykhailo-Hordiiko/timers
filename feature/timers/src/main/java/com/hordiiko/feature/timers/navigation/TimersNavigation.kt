package com.hordiiko.feature.timers.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.hordiiko.core.navigation.Screen
import com.hordiiko.feature.timers.presentation.TimersScreen

fun NavGraphBuilder.timersScreen() {
    composable(Screen.Timers.route) {
        TimersScreen()
    }
}