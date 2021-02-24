package com.ruangaldo.weatherapps.data.repository

import com.ruangaldo.weatherapps.utils.OnSingleResponse

interface WeatherRepo {
    fun getDataMain(listener:OnSingleResponse<String>)
}