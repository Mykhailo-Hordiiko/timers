package com.hordiiko.feature.timers.main.presentation

import androidx.annotation.StringRes
import androidx.compose.ui.graphics.vector.ImageVector
import com.hordiiko.core.timers.TimerType

internal data class TimerTabItem(
    val icon: ImageVector,
    @StringRes val contentDescriptionResId: Int,
    val timerType: TimerType
)