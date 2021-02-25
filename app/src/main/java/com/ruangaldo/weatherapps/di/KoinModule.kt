package com.ruangaldo.weatherapps.di

import com.ruangaldo.weatherapps.data.local.WeatherDao
import com.ruangaldo.weatherapps.data.local.WeatherDatabase
import com.ruangaldo.weatherapps.data.remote.ApiModule
import com.ruangaldo.weatherapps.data.repository.WeatherRepoImp
import com.ruangaldo.weatherapps.ui.WeatherViewModel
import com.ruangaldo.weatherapps.utils.App
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val repositoryModule= module {
    single { WeatherRepoImp(get(),get()) }
}
val uiModule= module {
    viewModel { WeatherViewModel(get()) }
}
val apiModule= module {
    single { ApiModule.service }
}
val dbModule =module{
    single { WeatherDatabase.getAppDataBase(context = get()) }
    factory { get<WeatherDatabase>().weatherDao() }
}