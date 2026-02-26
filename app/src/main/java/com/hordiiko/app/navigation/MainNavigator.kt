package com.hordiiko.app.navigation

import androidx.navigation.NavHostController
import com.hordiiko.core.screen.Screen

internal class MainNavigator(
    private val navController: NavHostController
) : Navigator {

    override fun goBack() {
        navController.popBackStack()
    }

    override fun navigateToRoot(screen: Screen) {
        val graphId: Int = navController.graph.id

        navController.navigate(screen.route) {
            launchSingleTop = true

            popUpTo(graphId) {
                inclusive = true
            }
        }
    }

    override fun navigateTo(screen: Screen) {
        navController.navigate(screen.route) {
            launchSingleTop = true
        }
    }
}