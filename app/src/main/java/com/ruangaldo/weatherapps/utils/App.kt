package com.ruangaldo.weatherapps.utils

import android.app.Application
import android.content.Context
import com.ruangaldo.weatherapps.data.di.apiModule
import com.ruangaldo.weatherapps.data.di.repositoryModule
import com.ruangaldo.weatherapps.data.di.uiModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.loadKoinModules
import org.koin.core.context.startKoin
import java.lang.ref.WeakReference

class App : Application() {
    companion object {
        lateinit var context: WeakReference<Context>
    }

    override fun onCreate() {
        super.onCreate()
        context = WeakReference(applicationContext)
        startKoin {
            androidLogger()
            androidContext(this@App)
            loadKoinModules(listOf(uiModule, repositoryModule, apiModule))
        }

    }
}