package com.hordiiko.feature.timers.stopwatch.presentation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.lifecycle.viewmodel.compose.viewModel
import com.hordiiko.core.screen.ScreenController
import com.hordiiko.core.screen.stopwatchCreateScreenConfig

@Composable
internal fun StopwatchCreateScreen(
    screenController: ScreenController,
    viewModel: StopwatchCreateViewModel = viewModel()
) {
    LaunchedEffect(Unit) {
        screenController.updateConfig(
            stopwatchCreateScreenConfig(
                onBackButtonClick = {
                    screenController.performAction(viewModel.onBackButtonClick())
                },
                onConfirmButtonClick = {
                    screenController.performAction(viewModel.onConfirmButtonClick())
                }
            )
        )
    }
}