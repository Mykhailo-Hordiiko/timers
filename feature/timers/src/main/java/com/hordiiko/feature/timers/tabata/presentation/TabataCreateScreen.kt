package com.hordiiko.feature.timers.tabata.presentation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.lifecycle.viewmodel.compose.viewModel
import com.hordiiko.core.screen.ScreenController
import com.hordiiko.core.screen.tabataCreateScreenConfig

@Composable
internal fun TabataCreateScreen(
    screenController: ScreenController,
    viewModel: TabataCreateViewModel = viewModel()
) {
    LaunchedEffect(Unit) {
        screenController.updateConfig(
            tabataCreateScreenConfig(
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