package com.hordiiko.feature.statistics.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.hordiiko.core.screen.Screen
import com.hordiiko.core.screen.ScreenController
import com.hordiiko.feature.statistics.presentation.StatisticsScreen

fun NavGraphBuilder.statisticsNavGraph(screenController: ScreenController) {
    composable(Screen.Statistics.route) { StatisticsScreen(screenController) }
}