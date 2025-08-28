package com.hordiiko.timers.ui

import androidx.annotation.StringRes
import androidx.compose.ui.graphics.vector.ImageVector
import com.hordiiko.core.navigation.Screen

internal data class NavigationItem(
    val icon: ImageVector,
    @StringRes val labelResId: Int,
    val screen: Screen
)