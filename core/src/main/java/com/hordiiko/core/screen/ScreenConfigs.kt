package com.hordiiko.core.screen

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.ArrowBack
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.icons.outlined.Done
import androidx.compose.material.icons.outlined.InsertChart
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material.icons.outlined.Timer
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

// region Navigation

val navigationBarItemsConfig: List<NavigationBarItemConfig> =
    listOf(
        NavigationBarItemConfig(
            icon = Icons.Outlined.Timer,
            labelResId = R.string.screen_timers,
            route = Screen.Timers.route
        ),
        NavigationBarItemConfig(
            icon = Icons.Outlined.InsertChart,
            labelResId = R.string.screen_statistics,
            route = Screen.Statistics.route
        ),
        NavigationBarItemConfig(
            icon = Icons.Outlined.Settings,
            labelResId = R.string.screen_settings,
            route = Screen.Settings.route
        )
    )

// endregion

// region Root Screens

fun timersConfig(
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

fun statisticsConfig(): ScreenConfig =
    ScreenConfig(
        topAppBar = TopAppBarConfig(
            headlineResId = R.string.screen_statistics
        ),
        isNavigationBarVisible = true
    )

fun settingsConfig(): ScreenConfig =
    ScreenConfig(
        topAppBar = TopAppBarConfig(
            headlineResId = R.string.screen_settings
        ),
        isNavigationBarVisible = true
    )

// endregion

// region Timer Create Screens

private fun timerCreateConfig(
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


fun stopwatchCreateConfig(
    onBackButtonClick: () -> Unit = {},
    onConfirmButtonClick: () -> Unit = {}
): ScreenConfig =
    timerCreateConfig(
        headlineResId = R.string.timer_new_stopwatch,
        onBackButtonClick = onBackButtonClick,
        onConfirmButtonClick = onConfirmButtonClick
    )

fun countdownCreateConfig(
    onBackButtonClick: () -> Unit = {},
    onConfirmButtonClick: () -> Unit = {}
): ScreenConfig =
    timerCreateConfig(
        headlineResId = R.string.timer_new_countdown,
        onBackButtonClick = onBackButtonClick,
        onConfirmButtonClick = onConfirmButtonClick
    )

fun pomodoroCreateConfig(
    onBackButtonClick: () -> Unit = {},
    onConfirmButtonClick: () -> Unit = {}
): ScreenConfig =
    timerCreateConfig(
        headlineResId = R.string.timer_new_pomodoro,
        onBackButtonClick = onBackButtonClick,
        onConfirmButtonClick = onConfirmButtonClick
    )

fun tabataCreateConfig(
    onBackButtonClick: () -> Unit = {},
    onConfirmButtonClick: () -> Unit = {}
): ScreenConfig =
    timerCreateConfig(
        headlineResId = R.string.timer_new_tabata,
        onBackButtonClick = onBackButtonClick,
        onConfirmButtonClick = onConfirmButtonClick
    )

// endregion