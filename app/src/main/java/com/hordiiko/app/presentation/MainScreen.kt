package com.hordiiko.app.presentation

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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.InsertChart
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material.icons.outlined.Timer
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
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.core.view.WindowInsetsControllerCompat
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.hordiiko.app.navigation.MainNavHost
import com.hordiiko.core.R
import com.hordiiko.core.navigation.currentRouteOrDefault
import com.hordiiko.core.navigation.navigateToRoot
import com.hordiiko.core.screen.FabConfig
import com.hordiiko.core.screen.NavigationBarItemConfig
import com.hordiiko.core.screen.Screen
import com.hordiiko.core.screen.ScreenConfig
import com.hordiiko.core.screen.ScreenController
import com.hordiiko.core.screen.TopAppBarButtonConfig
import com.hordiiko.core.screen.TopAppBarConfig

// region Screen

@Composable
internal fun MainScreen(startScreen: Screen, startScreenConfig: ScreenConfig) {
    val viewModel: MainViewModel = viewModel(
        factory = MainViewModelFactory(startScreenConfig)
    )

    val navController: NavHostController = rememberNavController()
    val screenController: ScreenController = remember(navController) {
        MainScreenController(
            navController = navController,
            updateScreenConfig = viewModel::updateScreenConfig
        )
    }

    val currentRoute: String = navController.currentRouteOrDefault(startScreen.route)
    val screenConfig: ScreenConfig = viewModel.screenConfig

    MainStatusBarAppearance()

    Scaffold(
        topBar = {
            MainTopAppBar(
                config = screenConfig.topAppBar
            )
        },
        floatingActionButton = {
            MainFab(
                config = screenConfig.fab
            )
        },
        bottomBar = {
            MainNavigationBar(
                isVisible = screenConfig.isNavigationBarVisible,
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
            MainNavHost(
                navController = navController,
                screenController = screenController,
                startScreen = startScreen
            )
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
private fun MainTopAppBar(config: TopAppBarConfig?) {
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
                            config = it.leadingButton
                        )
                    },
                    title = {
                        MainTopAppBarTitle(
                            resId = it.headlineResId
                        )
                    },
                    actions = {
                        MainTopAppBarButton(
                            config = it.trailingButton
                        )
                    }
                )
            }
        }
    }
}

@Composable
private fun MainTopAppBarButton(config: TopAppBarButtonConfig?) {
    config?.let {
        IconButton(
            onClick = it.onClick
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

// region Fab

@Composable
private fun MainFab(config: FabConfig?) {
    AnimatedVisibility(
        visible = config != null,
        enter = scaleIn() + fadeIn(),
        exit = scaleOut() + fadeOut()
    ) {
        config?.let {
            FloatingActionButton(
                onClick = it.onClick
            ) {
                Icon(
                    imageVector = it.icon,
                    contentDescription = stringResource(it.contentDescriptionResId)
                )
            }
        }
    }
}

// endregion

// region NavigationBar

private val navigationBarItemsConfig: List<NavigationBarItemConfig> =
    listOf(
        NavigationBarItemConfig(
            icon = Icons.Outlined.Timer,
            labelResId = R.string.screen_timers,
            screen = Screen.Timers
        ),
        NavigationBarItemConfig(
            icon = Icons.Outlined.InsertChart,
            labelResId = R.string.screen_statistics,
            screen = Screen.Statistics
        ),
        NavigationBarItemConfig(
            icon = Icons.Outlined.Settings,
            labelResId = R.string.screen_settings,
            screen = Screen.Settings
        )
    )

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
            navigationBarItemsConfig.forEach { config ->
                MainNavigationBarItem(
                    config = config,
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
        selected = config.screen.route == currentRoute,
        onClick = {
            if (config.screen.route != currentRoute) {
                navController.navigateToRoot(config.screen)
            }
        }
    )
}

// endregion