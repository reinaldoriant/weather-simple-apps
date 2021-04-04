package com.ruangaldo.weatherapps.data.repository

import com.ruangaldo.weatherapps.data.model.CurrentWeatherMsg
import io.reactivex.Flowable

interface WeatherRepo {
    fun getCurrentWeather(): Flowable<CurrentWeatherMsg>
}