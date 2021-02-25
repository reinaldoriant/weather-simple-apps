package com.ruangaldo.weatherapps.utils

import android.app.Application
import android.content.Context
import com.ruangaldo.weatherapps.BuildConfig
import com.ruangaldo.weatherapps.di.apiModule
import com.ruangaldo.weatherapps.di.dbModule
import com.ruangaldo.weatherapps.di.repositoryModule
import com.ruangaldo.weatherapps.di.uiModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.loadKoinModules
import org.koin.core.context.startKoin
import timber.log.Timber
import java.lang.ref.WeakReference

class App : Application() {
    companion object {
        lateinit var context: WeakReference<Context>
    }

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
        context = WeakReference(applicationContext)
        startKoin {
            androidLogger()
            context.get()?.let { androidContext(it) }
            loadKoinModules(listOf(uiModule, repositoryModule, apiModule, dbModule))
        }
    }


}
