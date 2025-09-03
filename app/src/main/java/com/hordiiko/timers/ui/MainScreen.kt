package com.hordiiko.timers.ui

import android.app.Activity
import android.view.View
import android.view.Window
import androidx.annotation.StringRes
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import androidx.compose.ui.text.style.TextOverflow
import androidx.core.view.WindowInsetsControllerCompat
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.hordiiko.core.navigation.Screen
import com.hordiiko.core.navigation.currentRouteOrDefault
import com.hordiiko.core.navigation.navigateToRootScreen
import com.hordiiko.timers.navigation.AppNavGraph

// region Screen

@Composable
internal fun MainScreen() {
    val navController: NavHostController = rememberNavController()
    val currentRoute: String = navController.currentRouteOrDefault(Screen.Timers.route)
    val currentScreen: Screen = Screen.getByRouteOrDefault(currentRoute)
    val currentScreenConfig: ScreenConfig = currentScreen.config

    MainStatusBarAppearance()

    Scaffold(
        topBar = {
            MainTopAppBar(
                config = currentScreenConfig.topAppBar,
                navController = navController
            )
        },
        floatingActionButton = {
            MainFabMenu(
                config = currentScreenConfig.fabMenu
            )
        },
        bottomBar = {
            MainNavigationBar(
                isVisible = currentScreenConfig.isNavigationBarVisible,
                currentRoute = currentRoute,
                navController = navController
            )
        }
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

// endregion

// region StatusBar

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

// endregion

// region TopAppBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun MainTopAppBar(config: TopAppBarConfig?, navController: NavHostController) {
    Box(
        modifier = Modifier.statusBarsPadding()
    ) {
        AnimatedVisibility(
            visible = config != null,
            enter = slideInVertically(
                initialOffsetY = { -it }
            ) + fadeIn(),
            exit = slideOutVertically(
                targetOffsetY = { -it }
            ) + fadeOut()
        ) {
            config?.let {
                TopAppBar(
                    navigationIcon = {
                        MainTopAppBarButton(
                            config = it.leadingButton,
                            navController = navController
                        )
                    },
                    title = {
                        MainTopAppBarTitle(
                            resId = it.headlineResId
                        )
                    },
                    actions = {
                        MainTopAppBarButton(
                            config = it.trailingButton,
                            navController = navController
                        )
                    }
                )
            }
        }
    }
}

@Composable
private fun MainTopAppBarButton(config: TopAppBarButtonConfig?, navController: NavHostController) {
    config?.let {
        IconButton(
            onClick = {
                performAction(
                    action = it.action,
                    navController = navController
                )
            }
        ) {
            Icon(
                imageVector = it.icon,
                contentDescription = stringResource(it.contentDescriptionResId)
            )
        }
    }
}

@Composable
private fun MainTopAppBarTitle(@StringRes resId: Int) {
    Text(
        text = stringResource(resId),
        maxLines = 1,
        overflow = TextOverflow.Ellipsis
    )
}

// endregion

// region FabMenu

@Composable
private fun MainFabMenu(config: FabMenuConfig?) {
    AnimatedVisibility(
        visible = config != null,
        enter = scaleIn() + fadeIn(),
        exit = scaleOut() + fadeOut()
    ) {
        config?.let {
            FloatingActionButton(
                onClick = {}
            ) {
                Icon(
                    imageVector = it.button.collapsedIcon,
                    contentDescription = stringResource(it.button.collapsedContentDescriptionResId)
                )
            }
        }
    }
}

// endregion

// region NavigationBar

@Composable
private fun MainNavigationBar(
    isVisible: Boolean,
    currentRoute: String,
    navController: NavHostController
) {
    AnimatedVisibility(
        visible = isVisible,
        enter = slideInVertically(
            initialOffsetY = { it }
        ) + fadeIn(),
        exit = slideOutVertically(
            targetOffsetY = { it }
        ) + fadeOut()
    ) {
        NavigationBar {
            navigationBarItems.forEach { item ->
                MainNavigationBarItem(
                    config = item,
                    currentRoute = currentRoute,
                    navController = navController
                )
            }
        }
    }
}

@Composable
private fun RowScope.MainNavigationBarItem(
    config: NavigationBarItemConfig,
    currentRoute: String,
    navController: NavHostController
) {
    NavigationBarItem(
        icon = {
            Icon(
                imageVector = config.icon,
                contentDescription = null
            )
        },
        label = {
            Text(
                text = stringResource(config.labelResId)
            )
        },
        selected = config.route == currentRoute,
        onClick = {
            if (config.route != currentRoute) {
                navController.navigateToRootScreen(config.route)
            }
        }
    )
}

// endregion

// region ScreenAction

private fun performAction(action: ScreenAction, navController: NavHostController) {

}

// endregion