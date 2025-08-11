package com.hordiiko.core.navigation

sealed class Screen(val route: String) {
    data object Timers : Screen("timers")
    data object Statistics : Screen("statistics")
    data object Settings : Screen("settings")
}