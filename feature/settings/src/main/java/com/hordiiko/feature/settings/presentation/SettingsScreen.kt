package com.hordiiko.feature.settings.presentation

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.hordiiko.core.R

@Composable
fun SettingsScreen() {
    Text(
        text = stringResource(R.string.settings)
    )
}