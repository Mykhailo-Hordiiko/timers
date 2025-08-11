package com.hordiiko.timers.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.hordiiko.core.navigation.Screen
import com.hordiiko.feature.settings.navigation.settingsScreen
import com.hordiiko.feature.statistics.navigation.statisticsScreen
import com.hordiiko.feature.timers.navigation.timersScreen

@Composable
internal fun AppNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.Timers.route
    ) {
        timersScreen()
        statisticsScreen()
        settingsScreen()
    }
}