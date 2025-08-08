package com.hordiiko.feature.statistics.presentation

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.hordiiko.core.R

@Composable
fun StatisticsScreen() {
    Text(
        text = stringResource(R.string.statistics)
    )
}