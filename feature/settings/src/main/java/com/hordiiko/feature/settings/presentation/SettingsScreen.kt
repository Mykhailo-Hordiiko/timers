package com.hordiiko.feature.settings.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.hordiiko.core.R
import com.hordiiko.core.screen.ScreenController
import com.hordiiko.core.screen.settingsConfig

@Composable
internal fun SettingsScreen(screenController: ScreenController) {
    LaunchedEffect(Unit) {
        screenController.updateConfig(settingsConfig())
    }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = stringResource(R.string.screen_settings)
        )
    }
}