package com.hordiiko.timers.ui.navigation

import androidx.annotation.StringRes
import androidx.compose.ui.graphics.vector.ImageVector

internal data class NavigationItem(
    val icon: ImageVector,
    @StringRes val labelResId: Int
)