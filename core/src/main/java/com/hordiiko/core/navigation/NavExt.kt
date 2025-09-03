package com.hordiiko.core.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState

@Composable
fun NavController.currentRouteOrDefault(default: String = ""): String =
    this.currentBackStackEntryAsState().value?.destination?.route ?: default

fun NavController.navigateToRootScreen(route: String) {
    val graphId: Int = this.graph.id

    this.navigate(route) {
        launchSingleTop = true

        popUpTo(graphId) {
            inclusive = true
        }
    }
}