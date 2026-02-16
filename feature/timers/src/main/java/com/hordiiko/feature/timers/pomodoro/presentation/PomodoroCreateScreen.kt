package com.hordiiko.feature.timers.pomodoro.presentation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.lifecycle.viewmodel.compose.viewModel
import com.hordiiko.core.screen.ScreenController
import com.hordiiko.core.screen.pomodoroCreateConfig

@Composable
internal fun PomodoroCreateScreen(
    screenController: ScreenController,
    viewModel: PomodoroCreateViewModel = viewModel()
) {
    LaunchedEffect(Unit) {
        screenController.updateConfig(
            pomodoroCreateConfig(
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