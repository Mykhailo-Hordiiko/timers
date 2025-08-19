package com.hordiiko.core.timers

sealed class TimerType(val type: String) {
    data object Stopwatch : TimerType("stopwatch")
    data object Countdown : TimerType("countdown")
    data object Pomodoro : TimerType("pomodoro")
    data object Tabata : TimerType("tabata")
}