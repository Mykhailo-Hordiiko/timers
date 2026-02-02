package com.hordiiko.feature.timers.tabata.presentation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.lifecycle.viewmodel.compose.viewModel
import com.hordiiko.core.screen.ScreenAction
import com.hordiiko.core.screen.ScreenConfig
import com.hordiiko.core.screen.tabataCreateConfig

@Composable
internal fun TabataCreateScreen(
    updateScreenConfig: (ScreenConfig) -> Unit,
    performScreenAction: (ScreenAction) -> Unit,
    viewModel: TabataCreateViewModel = viewModel()
) {
    LaunchedEffect(Unit) {
        updateScreenConfig(
            tabataCreateConfig(
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