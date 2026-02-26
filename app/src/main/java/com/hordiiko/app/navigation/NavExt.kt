package com.hordiiko.app.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.hordiiko.core.screen.Screen

@Composable
internal fun NavController.currentRouteOrDefault(default: Screen): String =
    this.currentBackStackEntryAsState().value?.destination?.route ?: default.route