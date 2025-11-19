package com.hordiiko.timers.ui

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.ArrowBack
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.icons.outlined.Close
import androidx.compose.material.icons.outlined.Done
import androidx.compose.material.icons.outlined.FitnessCenter
import androidx.compose.material.icons.outlined.HourglassEmpty
import androidx.compose.material.icons.outlined.InsertChart
import androidx.compose.material.icons.outlined.School
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material.icons.outlined.Timer
import com.hordiiko.core.R
import com.hordiiko.core.navigation.Screen

private val timersFabMenuItems: List<FabMenuItemConfig> =
    listOf(
        FabMenuItemConfig(
            icon = Icons.Outlined.Timer,
            labelResId = R.string.timer_stopwatch,
            action = ScreenAction.NavigateToStopwatchCreate
        ),
        FabMenuItemConfig(
            icon = Icons.Outlined.HourglassEmpty,
            labelResId = R.string.timer_countdown,
            action = ScreenAction.NavigateToCountdownCreate
        ),
        FabMenuItemConfig(
            icon = Icons.Outlined.School,
            labelResId = R.string.timer_pomodoro,
            action = ScreenAction.NavigateToPomodoroCreate
        ),
        FabMenuItemConfig(
            icon = Icons.Outlined.FitnessCenter,
            labelResId = R.string.timer_tabata,
            action = ScreenAction.NavigateToTabataCreate
        )
    )

internal val navigationBarItems: List<NavigationBarItemConfig> =
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


private val timers: ScreenConfig =
    ScreenConfig(
        topAppBar = TopAppBarConfig(
            headlineResId = R.string.screen_timers
        ),
        fabMenu = FabMenuConfig(
            button = FabMenuButtonConfig(
                collapsedIcon = Icons.Outlined.Add,
                expandedIcon = Icons.Outlined.Close,
                collapsedContentDescriptionResId = R.string.cd_timer_open_create_menu,
                expandedContentDescriptionResId = R.string.cd_timer_close_create_menu
            ),
            items = timersFabMenuItems
        ),
        isNavigationBarVisible = true
    )

private val statistics: ScreenConfig =
    ScreenConfig(
        topAppBar = TopAppBarConfig(
            headlineResId = R.string.screen_statistics
        ),
        isNavigationBarVisible = true
    )

private val settings: ScreenConfig =
    ScreenConfig(
        topAppBar = TopAppBarConfig(
            headlineResId = R.string.screen_settings
        ),
        isNavigationBarVisible = true
    )


private val backButton: TopAppBarButtonConfig =
    TopAppBarButtonConfig(
        icon = Icons.AutoMirrored.Outlined.ArrowBack,
        contentDescriptionResId = R.string.cd_back,
        action = ScreenAction.GoBack
    )

private val stopwatchCreate: ScreenConfig =
    timerCreate(
        headlineResId = R.string.timer_new_stopwatch,
        trailingButtonAction = ScreenAction.SaveStopwatch
    )

private val countdownCreate: ScreenConfig =
    timerCreate(
        headlineResId = R.string.timer_new_countdown,
        trailingButtonAction = ScreenAction.SaveCountdown
    )

private val pomodoroCreate: ScreenConfig =
    timerCreate(
        headlineResId = R.string.timer_new_pomodoro,
        trailingButtonAction = ScreenAction.SavePomodoro
    )

private val tabataCreate: ScreenConfig =
    timerCreate(
        headlineResId = R.string.timer_new_tabata,
        trailingButtonAction = ScreenAction.SaveTabata
    )

private fun timerCreate(
    @StringRes headlineResId: Int,
    trailingButtonAction: ScreenAction
): ScreenConfig =
    ScreenConfig(
        topAppBar = TopAppBarConfig(
            leadingButton = backButton,
            headlineResId = headlineResId,
            trailingButton = TopAppBarButtonConfig(
                icon = Icons.Outlined.Done,
                contentDescriptionResId = R.string.cd_confirm,
                action = trailingButtonAction
            )
        ),
        isNavigationBarVisible = false
    )


internal val Screen.config: ScreenConfig
    get() = when (this) {
        Screen.Timers -> timers
        Screen.Statistics -> statistics
        Screen.Settings -> settings

        Screen.StopwatchCreate -> stopwatchCreate
        Screen.CountdownCreate -> countdownCreate
        Screen.PomodoroCreate -> pomodoroCreate
        Screen.TabataCreate -> tabataCreate
    }