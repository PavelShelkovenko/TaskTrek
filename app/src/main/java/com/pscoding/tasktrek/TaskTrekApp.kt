package com.pscoding.tasktrek

import android.app.Application
import com.pscoding.tasktrek.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin

class TaskTrekApp: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin{
            androidLogger()
            androidContext(this@TaskTrekApp)
            modules(appModule)
        }
    }
}