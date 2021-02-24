package com.ruangaldo.weatherapps.data.di

import com.ruangaldo.weatherapps.data.remote.ApiModule
import com.ruangaldo.weatherapps.data.repository.WeatherRepository
import com.ruangaldo.weatherapps.ui.WeatherViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val repositoryModule= module {
    single { WeatherRepository(get()) }
}
val uiModule= module {
    viewModel { WeatherViewModel(get()) }
}
val apiModule= module {
    single { ApiModule.service }
}