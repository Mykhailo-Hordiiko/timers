package com.hordiiko.core.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.hordiiko.core.screen.Screen

@Composable
fun NavController.currentRouteOrDefault(default: String): String =
    this.currentBackStackEntryAsState().value?.destination?.route ?: default

fun NavController.navigateToRoot(screen: Screen) {
    val graphId: Int = this.graph.id

    this.navigate(screen.route) {
        launchSingleTop = true

        popUpTo(graphId) {
            inclusive = true
        }
    }
}

fun NavController.navigateTo(screen: Screen) {
    this.navigate(screen.route) {
        launchSingleTop = true
    }
}