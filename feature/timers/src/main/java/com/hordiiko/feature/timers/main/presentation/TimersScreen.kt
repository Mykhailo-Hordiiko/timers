package com.hordiiko.feature.timers.main.presentation

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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import com.hordiiko.core.R
import com.hordiiko.core.screen.ScreenController
import com.hordiiko.core.screen.timersConfig
import com.hordiiko.core.timers.TimerType
import com.hordiiko.core.ui.theme.spacing
import com.hordiiko.feature.timers.countdown.presentation.CountdownList
import com.hordiiko.feature.timers.pomodoro.presentation.PomodoroList
import com.hordiiko.feature.timers.stopwatch.presentation.StopwatchList
import com.hordiiko.feature.timers.tabata.presentation.TabataList

private val tabItems: List<TimerTabItem> =
    listOf(
        TimerTabItem(
            icon = Icons.Outlined.Timer,
            contentDescriptionResId = R.string.cd_timer_stopwatch,
            timerType = TimerType.Stopwatch
        ),
        TimerTabItem(
            icon = Icons.Outlined.HourglassEmpty,
            contentDescriptionResId = R.string.cd_timer_countdown,
            timerType = TimerType.Countdown
        ),
        TimerTabItem(
            icon = Icons.Outlined.School,
            contentDescriptionResId = R.string.cd_timer_pomodoro,
            timerType = TimerType.Pomodoro
        ),
        TimerTabItem(
            icon = Icons.Outlined.FitnessCenter,
            contentDescriptionResId = R.string.cd_timer_tabata,
            timerType = TimerType.Tabata
        )
    )


@Composable
internal fun TimersScreen(
    screenController: ScreenController,
    viewModel: TimersViewModel = viewModel()
) {
    LaunchedEffect(Unit) {
        screenController.updateConfig(
            timersConfig(
                onFabClick = {
                    screenController.performAction(viewModel.onFabClick())
                }
            )
        )
    }

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        TimersTabRow(
            items = tabItems,
            selectedType = viewModel.timerType,
            onTypeSelected = viewModel::selectTimerType
        )

        Crossfade(
            targetState = viewModel.timerType
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
            contentDescription = stringResource(item.contentDescriptionResId),
            tint = iconColor
        )
    }
}