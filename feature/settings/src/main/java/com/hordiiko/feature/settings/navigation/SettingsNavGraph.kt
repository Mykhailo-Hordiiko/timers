package com.hordiiko.feature.settings.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.hordiiko.core.navigation.Screen
import com.hordiiko.feature.settings.presentation.SettingsScreen

fun NavGraphBuilder.settingsNavGraph() {
    composable(Screen.Settings.route) { SettingsScreen() }
}