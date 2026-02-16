package com.hordiiko.feature.timers.countdown.presentation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.lifecycle.viewmodel.compose.viewModel
import com.hordiiko.core.screen.ScreenController
import com.hordiiko.core.screen.countdownCreateConfig

@Composable
internal fun CountdownCreateScreen(
    screenController: ScreenController,
    viewModel: CountdownCreateViewModel = viewModel()
) {
    LaunchedEffect(Unit) {
        screenController.updateConfig(
            countdownCreateConfig(
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