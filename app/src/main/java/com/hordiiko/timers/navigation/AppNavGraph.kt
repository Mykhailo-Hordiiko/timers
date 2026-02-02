package com.hordiiko.timers.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.hordiiko.core.screen.Screen
import com.hordiiko.core.screen.ScreenAction
import com.hordiiko.core.screen.ScreenConfig
import com.hordiiko.feature.settings.navigation.settingsNavGraph
import com.hordiiko.feature.statistics.navigation.statisticsNavGraph
import com.hordiiko.feature.timers.navigation.timersNavGraph

@Composable
internal fun AppNavGraph(
    navController: NavHostController,
    updateScreenConfig: (ScreenConfig) -> Unit,
    performScreenAction: (ScreenAction) -> Unit
) {
    NavHost(
        navController = navController,
        startDestination = Screen.Timers.route
    ) {
        timersNavGraph(
            updateScreenConfig = updateScreenConfig,
            performScreenAction = performScreenAction
        )
        statisticsNavGraph(
            updateScreenConfig = updateScreenConfig
        )
        settingsNavGraph(
            updateScreenConfig = updateScreenConfig
        )
    }
}