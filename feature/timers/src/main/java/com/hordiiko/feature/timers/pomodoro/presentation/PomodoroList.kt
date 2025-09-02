package com.hordiiko.feature.timers.pomodoro.presentation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.School
import androidx.compose.runtime.Composable
import com.hordiiko.core.R
import com.hordiiko.feature.timers.common.presentation.EmptyTimerList

@Composable
internal fun PomodoroList() {
    EmptyTimerList(
        icon = Icons.Outlined.School,
        titleResId = R.string.timer_pomodoro
    )
}