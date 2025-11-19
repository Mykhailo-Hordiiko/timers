package com.hordiiko.timers.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.hordiiko.core.navigation.Screen
import com.hordiiko.feature.settings.navigation.settingsNavGraph
import com.hordiiko.feature.statistics.navigation.statisticsNavGraph
import com.hordiiko.feature.timers.navigation.timersNavGraph

@Composable
internal fun AppNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.Timers.route
    ) {
        timersNavGraph()
        statisticsNavGraph()
        settingsNavGraph()
    }
}