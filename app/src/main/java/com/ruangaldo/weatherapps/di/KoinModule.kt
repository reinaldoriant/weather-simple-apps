package com.ruangaldo.weatherapps.di

import android.app.Application
import androidx.room.Room
import com.ruangaldo.weatherapps.data.local.WeatherDatabase
import com.ruangaldo.weatherapps.data.remote.ApiModule
import com.ruangaldo.weatherapps.data.repository.WeatherRepoImp
import com.ruangaldo.weatherapps.ui.WeatherViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val repositoryModule = module {
    single { WeatherRepoImp(get(), get()) }
}
val uiModule = module {
    viewModel { WeatherViewModel(get()) }
}
val apiModule = module {
    single { ApiModule.service }
}
val dbModule = module {
    fun getAppDataBase(context: Application): WeatherDatabase {
        return Room.databaseBuilder(
            context.applicationContext,
            WeatherDatabase::class.java, "myDB"
        ).build()
    }
    single { getAppDataBase(androidApplication()) }
    factory { get<WeatherDatabase>().weatherDao() }
}