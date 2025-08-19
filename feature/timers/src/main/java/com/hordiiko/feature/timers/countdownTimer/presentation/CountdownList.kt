package com.hordiiko.feature.timers.countdownTimer.presentation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.HourglassEmpty
import androidx.compose.runtime.Composable
import com.hordiiko.core.R
import com.hordiiko.feature.timers.common.presentation.EmptyTimerList

@Composable
internal fun CountdownList() {
    EmptyTimerList(
        icon = Icons.Outlined.HourglassEmpty,
        titleResId = R.string.timer_countdown
    )
}