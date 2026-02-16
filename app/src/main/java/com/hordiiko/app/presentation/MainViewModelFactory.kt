package com.hordiiko.app.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.hordiiko.core.screen.ScreenConfig

class MainViewModelFactory(
    private val startScreenConfig: ScreenConfig
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T =
        MainViewModel(startScreenConfig) as T
}