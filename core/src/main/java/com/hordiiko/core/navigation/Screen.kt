package com.hordiiko.core.navigation

sealed class Screen(val route: String) {
    data object Timers : Screen("timers")
    data object Statistics : Screen("statistics")
    data object Settings : Screen("settings")

    data object StopwatchCreate : Screen("stopwatch_create")
    data object CountdownCreate : Screen("countdown_create")
    data object PomodoroCreate : Screen("pomodoro_create")
    data object TabataCreate : Screen("tabata_create")

    companion object {
        private val allScreens: List<Screen> by lazy {
            listOf(
                Timers,
                Statistics,
                Settings,

                StopwatchCreate,
                CountdownCreate,
                PomodoroCreate,
                TabataCreate
            )
        }

        fun getByRouteOrDefault(
            route: String,
            default: Screen = Timers
        ): Screen = allScreens.find { it.route == route } ?: default
    }
}