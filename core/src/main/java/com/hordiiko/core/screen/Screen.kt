package com.hordiiko.core.screen

sealed class Screen(val route: String) {
    data object Timers : Screen("timers")
    data object Statistics : Screen("statistics")
    data object Settings : Screen("settings")

    data object StopwatchCreate : Screen("stopwatch_create")
    data object CountdownCreate : Screen("countdown_create")
    data object PomodoroCreate : Screen("pomodoro_create")
    data object TabataCreate : Screen("tabata_create")
}