package com.hordiiko.core.screen

interface ScreenController {

    fun updateConfig(config: ScreenConfig)

    fun performAction(action: ScreenAction)
}