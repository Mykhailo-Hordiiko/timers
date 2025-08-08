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
import com.hordiiko.core.R
import com.hordiiko.feature.timers.presentation.TimersScreen
import com.hordiiko.timers.ui.navigation.NavigationItem

private val navigationItems: List<NavigationItem> =
    listOf(
        NavigationItem(Icons.Outlined.Timer, R.string.timers),
        NavigationItem(Icons.Outlined.InsertChart, R.string.statistics),
        NavigationItem(Icons.Outlined.Settings, R.string.settings)
    )


@Composable
internal fun MainScreen() {
    MainStatusBarAppearance()

    Scaffold(
        topBar = { MainTopAppBar() },
        bottomBar = { MainNavigationBar() }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            TimersScreen()
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
private fun MainTopAppBar() {
    TopAppBar(
        title = {
            Text(
                text = stringResource(R.string.timers)
            )
        }
    )
}

@Composable
private fun MainNavigationBar() {
    NavigationBar {
        navigationItems.forEach { item ->
            NavigationBarItem(
                selected = false,
                onClick = {},
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