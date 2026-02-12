package com.hordiiko.feature.timers.common.presentation

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import com.hordiiko.core.ui.theme.size
import com.hordiiko.core.ui.theme.spacing
import com.hordiiko.feature.timers.R

@Composable
internal fun EmptyTimerList(
    icon: ImageVector,
    @StringRes titleResId: Int
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(MaterialTheme.spacing.small),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            modifier = Modifier.size(MaterialTheme.size.large),
            imageVector = icon,
            contentDescription = null
        )

        Text(
            text = stringResource(titleResId),
            style = MaterialTheme.typography.titleMedium
        )

        Text(
            text = stringResource(R.string.timer_not_added_yet),
            style = MaterialTheme.typography.bodyMedium
        )
    }
}