package com.hordiiko.timers.ui.main

import android.app.Activity
import android.view.View
import android.view.Window
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.InsertChart
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material.icons.outlined.Timer
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.res.stringResource
import androidx.core.view.WindowInsetsControllerCompat
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.hordiiko.core.R
import com.hordiiko.core.navigation.Screen
import com.hordiiko.core.navigation.currentRouteOrDefault
import com.hordiiko.timers.navigation.AppNavGraph
import com.hordiiko.timers.navigation.NavigationItem

private val navigationItems: List<NavigationItem> =
    listOf(
        NavigationItem(Icons.Outlined.Timer, R.string.screen_timers, Screen.Timers),
        NavigationItem(Icons.Outlined.InsertChart, R.string.screen_statistics, Screen.Statistics),
        NavigationItem(Icons.Outlined.Settings, R.string.screen_settings, Screen.Settings)
    )


@Composable
internal fun MainScreen() {
    val navController: NavHostController = rememberNavController()

    MainStatusBarAppearance()

    Scaffold(
        topBar = { MainTopAppBar(navController) },
        bottomBar = { MainNavigationBar(navController) }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            AppNavGraph(navController)
        }
    }
}

@Composable
private fun MainStatusBarAppearance(
    isDarkTheme: Boolean = isSystemInDarkTheme()
) {
    val view: View = LocalView.current
    val activity: Activity = view.context as? Activity ?: return
    val window: Window = activity.window

    SideEffect {
        WindowInsetsControllerCompat(window, view).isAppearanceLightStatusBars = !isDarkTheme
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun MainTopAppBar(navController: NavHostController) {
    val currentRoute: String = navController.currentRouteOrDefault(Screen.Timers.route)
    val currentNavigationItem: NavigationItem? =
        navigationItems.find { it.screen.route == currentRoute }

    val label: String = currentNavigationItem?.labelResId?.let { stringResource(it) } ?: ""

    TopAppBar(
        title = {
            Text(
                text = label
            )
        }
    )
}

@Composable
private fun MainNavigationBar(navController: NavHostController) {
    NavigationBar {
        val currentRoute: String = navController.currentRouteOrDefault(Screen.Timers.route)

        navigationItems.forEach { item ->
            NavigationBarItem(
                selected = item.screen.route == currentRoute,
                onClick = {
                    navController.navigate(item.screen.route) {
                        launchSingleTop = true

                        popUpTo(navController.graph.id) {
                            inclusive = true
                        }
                    }
                },
                icon = {
                    Icon(
                        imageVector = item.icon,
                        contentDescription = null
                    )
                },
                label = {
                    Text(
                        text = stringResource(item.labelResId)
                    )
                }
            )
        }
    }
}