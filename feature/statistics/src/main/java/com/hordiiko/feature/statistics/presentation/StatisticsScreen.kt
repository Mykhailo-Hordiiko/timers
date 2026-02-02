package com.hordiiko.feature.statistics.presentation

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
import com.hordiiko.core.screen.statisticsConfig

@Composable
internal fun StatisticsScreen(
    updateScreenConfig: (ScreenConfig) -> Unit
) {
    LaunchedEffect(Unit) {
        updateScreenConfig(
            statisticsConfig()
        )
    }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = stringResource(R.string.screen_statistics)
        )
    }
}