package com.hordiiko.timers.ui

import androidx.annotation.StringRes
import androidx.compose.ui.graphics.vector.ImageVector

internal data class ScreenConfig(
    val topAppBar: TopAppBarConfig? = null,
    val fabMenu: FabMenuConfig? = null,
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


internal data class FabMenuConfig(
    val button: FabMenuButtonConfig,
    val items: List<FabMenuItemConfig>
)

internal data class FabMenuButtonConfig(
    val collapsedIcon: ImageVector,
    val expandedIcon: ImageVector,
    val collapsedContentDescriptionResId: Int,
    val expandedContentDescriptionResId: Int
)

internal data class FabMenuItemConfig(
    val icon: ImageVector,
    val labelResId: Int,
    val action: ScreenAction
)


internal data class NavigationBarItemConfig(
    val icon: ImageVector,
    @StringRes val labelResId: Int,
    val route: String
)