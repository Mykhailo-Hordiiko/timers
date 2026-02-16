package com.hordiiko.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.hordiiko.app.presentation.MainScreen
import com.hordiiko.core.screen.Screen
import com.hordiiko.core.screen.timersScreenConfig
import com.hordiiko.core.ui.theme.AppTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        setContent {
            AppTheme {
                MainScreen(
                    startScreen = Screen.Timers,
                    startScreenConfig = timersScreenConfig()
                )
            }
        }
    }
}