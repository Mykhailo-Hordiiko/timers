package com.hordiiko.feature.timers.timer.presentation

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.FitnessCenter
import androidx.compose.material.icons.outlined.HourglassEmpty
import androidx.compose.material.icons.outlined.School
import androidx.compose.material.icons.outlined.Timer
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import com.hordiiko.core.R
import com.hordiiko.core.timers.TimerType
import com.hordiiko.core.ui.theme.spacing
import com.hordiiko.feature.timers.countdownTimer.presentation.CountdownList
import com.hordiiko.feature.timers.pomodoroTimer.presentation.PomodoroList
import com.hordiiko.feature.timers.stopwatchTimer.presentation.StopwatchList
import com.hordiiko.feature.timers.tabataTimer.presentation.TabataList

private val tabItems: List<TimerTabItem> =
    listOf(
        TimerTabItem(Icons.Outlined.Timer, R.string.timer_stopwatch, TimerType.Stopwatch),
        TimerTabItem(Icons.Outlined.HourglassEmpty, R.string.timer_countdown, TimerType.Countdown),
        TimerTabItem(Icons.Outlined.School, R.string.timer_pomodoro, TimerType.Pomodoro),
        TimerTabItem(Icons.Outlined.FitnessCenter, R.string.timer_tabata, TimerType.Tabata)
    )


@Composable
internal fun TimersMainScreen() {
    var selectedType: TimerType by remember { mutableStateOf(TimerType.Stopwatch) }

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        TimersTabRow(
            items = tabItems,
            selectedType = selectedType,
            onTypeSelected = { selectedType = it }
        )

        Crossfade(
            targetState = selectedType
        ) { type ->
            when (type) {
                TimerType.Stopwatch -> StopwatchList()
                TimerType.Countdown -> CountdownList()
                TimerType.Pomodoro -> PomodoroList()
                TimerType.Tabata -> TabataList()
            }
        }
    }
}

@Suppress("SameParameterValue")
@Composable
private fun TimersTabRow(
    items: List<TimerTabItem>,
    selectedType: TimerType,
    onTypeSelected: (TimerType) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(MaterialTheme.spacing.small),
        horizontalArrangement = Arrangement.Center
    ) {
        items.forEach { item ->
            val isSelected: Boolean = item.timerType == selectedType

            TimerTab(
                item = item,
                isSelected = isSelected,
                onClick = onTypeSelected
            )
        }
    }
}

@Composable
private fun TimerTab(
    item: TimerTabItem,
    isSelected: Boolean,
    onClick: (TimerType) -> Unit
) {
    val iconColor: Color =
        if (isSelected) {
            MaterialTheme.colorScheme.onSecondaryContainer
        } else {
            MaterialTheme.colorScheme.onSurfaceVariant
        }
    val backgroundColor: Color =
        if (isSelected) {
            MaterialTheme.colorScheme.secondaryContainer
        } else {
            Color.Transparent
        }

    Box(
        modifier = Modifier
            .clip(CircleShape)
            .clickable { onClick(item.timerType) }
            .background(backgroundColor)
    ) {
        Icon(
            modifier = Modifier
                .padding(
                    horizontal = MaterialTheme.spacing.medium,
                    vertical = MaterialTheme.spacing.extraSmall
                ),
            imageVector = item.icon,
            contentDescription = stringResource(item.descriptionResId),
            tint = iconColor
        )
    }
}