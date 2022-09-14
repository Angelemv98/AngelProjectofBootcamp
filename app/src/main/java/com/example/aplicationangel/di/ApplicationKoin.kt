package com.example.aplicationangel.di

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class ApplicationKoin : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@ApplicationKoin)
            modules(listOf(appModuleLogin, appModuleDashboard))
        }
    }
}
