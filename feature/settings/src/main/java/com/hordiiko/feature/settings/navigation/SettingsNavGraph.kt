package com.hordiiko.feature.settings.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.hordiiko.core.screen.Screen
import com.hordiiko.core.screen.ScreenController
import com.hordiiko.feature.settings.presentation.SettingsScreen

fun NavGraphBuilder.settingsNavGraph(screenController: ScreenController) {
    composable(Screen.Settings.route) { SettingsScreen(screenController) }
}