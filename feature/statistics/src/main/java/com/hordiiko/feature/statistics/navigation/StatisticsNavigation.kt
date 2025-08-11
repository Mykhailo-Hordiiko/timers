package com.hordiiko.feature.statistics.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.hordiiko.core.navigation.Screen
import com.hordiiko.feature.statistics.presentation.StatisticsScreen

fun NavGraphBuilder.statisticsScreen() {
    composable(Screen.Statistics.route) {
        StatisticsScreen()
    }
}