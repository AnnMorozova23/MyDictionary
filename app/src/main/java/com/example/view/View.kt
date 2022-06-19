package com.example.view

import com.example.mydictionary.data.AppState

interface View {
    fun renderData(appState: AppState)
}