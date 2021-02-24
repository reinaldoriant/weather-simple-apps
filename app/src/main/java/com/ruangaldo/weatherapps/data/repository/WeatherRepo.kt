package com.ruangaldo.weatherapps.data.repository

import com.ruangaldo.weatherapps.data.model.*
import com.ruangaldo.weatherapps.utils.OnSingleResponse

interface WeatherRepo {
    fun getDataSys(listener: OnSingleResponse<SysMsg>)
    fun getDataMain(listener: OnSingleResponse<MainMsg>)
    fun getDataInfo(listener: OnSingleResponse<InfoMsg>)
    fun getDataWind(listener: OnSingleResponse<WindMsg>)
    fun getDataWeather(listener: OnSingleResponse<WeatherMsg>)
}