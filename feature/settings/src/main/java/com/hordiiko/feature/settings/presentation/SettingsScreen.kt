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
import com.hordiiko.core.screen.ScreenConfig
import com.hordiiko.core.screen.settingsConfig

@Composable
internal fun SettingsScreen(
    updateScreenConfig: (ScreenConfig) -> Unit
) {
    LaunchedEffect(Unit) {
        updateScreenConfig(
            settingsConfig()
        )
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