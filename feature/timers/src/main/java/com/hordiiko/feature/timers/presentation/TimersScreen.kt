package com.hordiiko.feature.timers.presentation

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.hordiiko.core.R

@Composable
fun TimersScreen() {
    Text(
        text = stringResource(R.string.timers)
    )
}