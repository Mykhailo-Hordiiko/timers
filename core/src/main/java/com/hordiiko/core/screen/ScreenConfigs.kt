package com.hordiiko.core.screen

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.ArrowBack
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.icons.outlined.Done
import com.hordiiko.core.R

// region Common

private fun backButtonConfig(onClick: () -> Unit): TopAppBarButtonConfig =
    TopAppBarButtonConfig(
        icon = Icons.AutoMirrored.Outlined.ArrowBack,
        contentDescriptionResId = R.string.cd_back,
        onClick = onClick
    )

private fun confirmButtonConfig(onClick: () -> Unit): TopAppBarButtonConfig =
    TopAppBarButtonConfig(
        icon = Icons.Outlined.Done,
        contentDescriptionResId = R.string.cd_confirm,
        onClick = onClick
    )

// endregion

// region Root Screens

fun timersScreenConfig(
    onFabClick: () -> Unit = {}
): ScreenConfig =
    ScreenConfig(
        topAppBar = TopAppBarConfig(
            headlineResId = R.string.screen_timers
        ),
        fab = FabConfig(
            icon = Icons.Outlined.Add,
            contentDescriptionResId = R.string.cd_timer_create,
            onClick = onFabClick
        ),
        isNavigationBarVisible = true
    )

fun statisticsScreenConfig(): ScreenConfig =
    ScreenConfig(
        topAppBar = TopAppBarConfig(
            headlineResId = R.string.screen_statistics
        ),
        isNavigationBarVisible = true
    )

fun settingsScreenConfig(): ScreenConfig =
    ScreenConfig(
        topAppBar = TopAppBarConfig(
            headlineResId = R.string.screen_settings
        ),
        isNavigationBarVisible = true
    )

// endregion

// region Timer Create Screens

private fun timerCreateScreenConfig(
    @StringRes headlineResId: Int,
    onBackButtonClick: () -> Unit = {},
    onConfirmButtonClick: () -> Unit = {}
): ScreenConfig =
    ScreenConfig(
        topAppBar = TopAppBarConfig(
            leadingButton = backButtonConfig(onBackButtonClick),
            headlineResId = headlineResId,
            trailingButton = confirmButtonConfig(onConfirmButtonClick)
        )
    )


fun stopwatchCreateScreenConfig(
    onBackButtonClick: () -> Unit = {},
    onConfirmButtonClick: () -> Unit = {}
): ScreenConfig =
    timerCreateScreenConfig(
        headlineResId = R.string.timer_new_stopwatch,
        onBackButtonClick = onBackButtonClick,
        onConfirmButtonClick = onConfirmButtonClick
    )

fun countdownCreateScreenConfig(
    onBackButtonClick: () -> Unit = {},
    onConfirmButtonClick: () -> Unit = {}
): ScreenConfig =
    timerCreateScreenConfig(
        headlineResId = R.string.timer_new_countdown,
        onBackButtonClick = onBackButtonClick,
        onConfirmButtonClick = onConfirmButtonClick
    )

fun pomodoroCreateScreenConfig(
    onBackButtonClick: () -> Unit = {},
    onConfirmButtonClick: () -> Unit = {}
): ScreenConfig =
    timerCreateScreenConfig(
        headlineResId = R.string.timer_new_pomodoro,
        onBackButtonClick = onBackButtonClick,
        onConfirmButtonClick = onConfirmButtonClick
    )

fun tabataCreateScreenConfig(
    onBackButtonClick: () -> Unit = {},
    onConfirmButtonClick: () -> Unit = {}
): ScreenConfig =
    timerCreateScreenConfig(
        headlineResId = R.string.timer_new_tabata,
        onBackButtonClick = onBackButtonClick,
        onConfirmButtonClick = onConfirmButtonClick
    )

// endregion