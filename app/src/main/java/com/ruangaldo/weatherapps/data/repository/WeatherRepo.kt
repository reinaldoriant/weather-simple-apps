package com.ruangaldo.weatherapps.data.repository

import com.ruangaldo.weatherapps.data.model.*
import com.ruangaldo.weatherapps.utils.api.OnSingleResponse

interface WeatherRepo {
    fun getCurrentWeather(listener: OnSingleResponse<CurrentWeatherMsg>)
}