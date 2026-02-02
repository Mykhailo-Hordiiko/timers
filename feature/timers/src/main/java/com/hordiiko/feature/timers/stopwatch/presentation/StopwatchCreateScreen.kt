package com.hordiiko.feature.timers.stopwatch.presentation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.lifecycle.viewmodel.compose.viewModel
import com.hordiiko.core.screen.ScreenAction
import com.hordiiko.core.screen.ScreenConfig
import com.hordiiko.core.screen.stopwatchCreateConfig

@Composable
internal fun StopwatchCreateScreen(
    updateScreenConfig: (ScreenConfig) -> Unit,
    performScreenAction: (ScreenAction) -> Unit,
    viewModel: StopwatchCreateViewModel = viewModel()
) {
    LaunchedEffect(Unit) {
        updateScreenConfig(
            stopwatchCreateConfig(
                onBackButtonClick = {
                    performScreenAction(viewModel.onBackButtonClick())
                },
                onConfirmButtonClick = {
                    performScreenAction(viewModel.onConfirmButtonClick())
                }
            )
        )
    }
}