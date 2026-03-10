package com.hordiiko.app.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.hordiiko.core.screen.Screen
import com.hordiiko.core.screen.ScreenController
import com.hordiiko.feature.settings.navigation.settingsNavGraph
import com.hordiiko.feature.statistics.navigation.statisticsNavGraph
import com.hordiiko.feature.timers.navigation.timersNavGraph

@Composable
internal fun MainNavHost(
    modifier: Modifier,
    startScreen: Screen,
    navController: NavHostController,
    screenController: ScreenController
) {
    NavHost(
        modifier = modifier,
        startDestination = startScreen.route,
        navController = navController
    ) {
        timersNavGraph(screenController)
        statisticsNavGraph(screenController)
        settingsNavGraph(screenController)
    }
}