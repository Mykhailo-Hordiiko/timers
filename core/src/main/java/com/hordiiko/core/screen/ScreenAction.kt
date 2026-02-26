package com.hordiiko.core.screen

sealed interface ScreenAction {

    data object GoBack : ScreenAction

    sealed interface TimerCreate : ScreenAction {
        data object Stopwatch : TimerCreate
        data object Countdown : TimerCreate
        data object Pomodoro : TimerCreate
        data object Tabata : TimerCreate
    }
}