package com.hordiiko.app.navigation

import com.hordiiko.core.screen.Screen

internal interface Navigator {

    fun goBack()

    fun navigateToRoot(screen: Screen)

    fun navigateTo(screen: Screen)
}