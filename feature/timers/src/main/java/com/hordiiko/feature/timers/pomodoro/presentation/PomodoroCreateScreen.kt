package com.hordiiko.feature.timers.pomodoro.presentation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.lifecycle.viewmodel.compose.viewModel
import com.hordiiko.core.screen.ScreenAction
import com.hordiiko.core.screen.ScreenConfig
import com.hordiiko.core.screen.pomodoroCreateConfig

@Composable
internal fun PomodoroCreateScreen(
    updateScreenConfig: (ScreenConfig) -> Unit,
    performScreenAction: (ScreenAction) -> Unit,
    viewModel: PomodoroCreateViewModel = viewModel()
) {
    LaunchedEffect(Unit) {
        updateScreenConfig(
            pomodoroCreateConfig(
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