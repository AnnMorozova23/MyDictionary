package com.example.mydictionary

import android.app.Application
import com.example.mydictionary.di.application
import com.example.mydictionary.di.mainScreen
import org.koin.core.context.startKoin

class App:Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(listOf(application, mainScreen))
        }
    }

}