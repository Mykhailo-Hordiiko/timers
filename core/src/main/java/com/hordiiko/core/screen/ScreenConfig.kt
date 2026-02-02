package com.hordiiko.core.screen

import androidx.annotation.StringRes
import androidx.compose.ui.graphics.vector.ImageVector

data class ScreenConfig(
    val topAppBar: TopAppBarConfig? = null,
    val fab: FabConfig? = null,
    val isNavigationBarVisible: Boolean = false
)


data class TopAppBarConfig(
    @StringRes val headlineResId: Int,
    val leadingButton: TopAppBarButtonConfig? = null,
    val trailingButton: TopAppBarButtonConfig? = null
)

data class TopAppBarButtonConfig(
    val icon: ImageVector,
    val contentDescriptionResId: Int,
    val onClick: () -> Unit
)


data class FabConfig(
    val icon: ImageVector,
    val contentDescriptionResId: Int,
    val onClick: () -> Unit
)


data class NavigationBarItemConfig(
    val icon: ImageVector,
    @StringRes val labelResId: Int,
    val route: String
)