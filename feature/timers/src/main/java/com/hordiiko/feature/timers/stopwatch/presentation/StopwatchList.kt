package com.hordiiko.feature.timers.stopwatch.presentation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Timer
import androidx.compose.runtime.Composable
import com.hordiiko.core.R
import com.hordiiko.feature.timers.common.presentation.EmptyTimerList

@Composable
internal fun StopwatchList() {
    EmptyTimerList(
        icon = Icons.Outlined.Timer,
        titleResId = R.string.timer_stopwatch
    )
}