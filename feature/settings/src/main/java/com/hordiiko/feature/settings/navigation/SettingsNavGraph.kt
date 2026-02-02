package com.hordiiko.feature.settings.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.hordiiko.core.screen.Screen
import com.hordiiko.core.screen.ScreenConfig
import com.hordiiko.feature.settings.presentation.SettingsScreen

fun NavGraphBuilder.settingsNavGraph(
    updateScreenConfig: (ScreenConfig) -> Unit
) {
    composable(Screen.Settings.route) {
        SettingsScreen(
            updateScreenConfig = updateScreenConfig
        )
    }
}