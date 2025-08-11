package com.hordiiko.core.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState

@Composable
fun NavController.currentRouteOrDefault(default: String = ""): String =
    this.currentBackStackEntryAsState().value?.destination?.route ?: default