package com.hordiiko.timers.ui

import androidx.annotation.StringRes
import androidx.compose.ui.graphics.vector.ImageVector

internal data class ScreenConfig(
    val topAppBar: TopAppBarConfig? = null,
    val fab: FabConfig? = null,
    val isNavigationBarVisible: Boolean = false
)


internal data class TopAppBarConfig(
    @StringRes val headlineResId: Int,
    val leadingButton: TopAppBarButtonConfig? = null,
    val trailingButton: TopAppBarButtonConfig? = null
)

internal data class TopAppBarButtonConfig(
    val icon: ImageVector,
    val contentDescriptionResId: Int,
    val action: ScreenAction
)


internal data class FabConfig(
    val icon: ImageVector,
    val contentDescriptionResId: Int,
    val action: ScreenAction
)


internal data class NavigationBarItemConfig(
    val icon: ImageVector,
    @StringRes val labelResId: Int,
    val route: String
)