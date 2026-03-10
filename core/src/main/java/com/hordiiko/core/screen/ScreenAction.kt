package com.hordiiko.core.screen

sealed interface ScreenAction {

    data object GoBack : ScreenAction

    sealed class TimerCreate(val screen: Screen) : ScreenAction {
        data object Stopwatch : TimerCreate(Screen.StopwatchCreate)
        data object Countdown : TimerCreate(Screen.CountdownCreate)
        data object Pomodoro : TimerCreate(Screen.PomodoroCreate)
        data object Tabata : TimerCreate(Screen.TabataCreate)
    }
}