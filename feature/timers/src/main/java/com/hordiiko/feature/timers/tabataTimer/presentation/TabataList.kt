package com.hordiiko.feature.timers.tabataTimer.presentation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.FitnessCenter
import androidx.compose.runtime.Composable
import com.hordiiko.core.R
import com.hordiiko.feature.timers.common.presentation.EmptyTimerList

@Composable
internal fun TabataList() {
    EmptyTimerList(
        icon = Icons.Outlined.FitnessCenter,
        titleResId = R.string.timer_tabata
    )
}