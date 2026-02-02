package com.hordiiko.feature.statistics.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.hordiiko.core.screen.Screen
import com.hordiiko.core.screen.ScreenConfig
import com.hordiiko.feature.statistics.presentation.StatisticsScreen

fun NavGraphBuilder.statisticsNavGraph(
    updateScreenConfig: (ScreenConfig) -> Unit
) {
    composable(Screen.Statistics.route) {
        StatisticsScreen(
            updateScreenConfig = updateScreenConfig
        )
    }
}