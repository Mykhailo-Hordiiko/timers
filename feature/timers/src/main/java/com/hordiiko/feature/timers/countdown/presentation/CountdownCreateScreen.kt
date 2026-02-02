package com.hordiiko.feature.timers.countdown.presentation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.lifecycle.viewmodel.compose.viewModel
import com.hordiiko.core.screen.ScreenAction
import com.hordiiko.core.screen.ScreenConfig
import com.hordiiko.core.screen.countdownCreateConfig

@Composable
internal fun CountdownCreateScreen(
    updateScreenConfig: (ScreenConfig) -> Unit,
    performScreenAction: (ScreenAction) -> Unit,
    viewModel: CountdownCreateViewModel = viewModel()
) {
    LaunchedEffect(Unit) {
        updateScreenConfig(
            countdownCreateConfig(
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