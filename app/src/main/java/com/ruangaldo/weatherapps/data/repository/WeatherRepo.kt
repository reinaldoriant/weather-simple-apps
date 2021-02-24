package com.ruangaldo.weatherapps.data.repository

import com.ruangaldo.weatherapps.data.model.MainMsg
import com.ruangaldo.weatherapps.data.model.SysMsg
import com.ruangaldo.weatherapps.data.model.WeatherMsg
import com.ruangaldo.weatherapps.data.model.WindMsg
import com.ruangaldo.weatherapps.utils.OnSingleResponse

interface WeatherRepo {
    fun getDataSys(listener: OnSingleResponse<SysMsg>)
    fun getDataMain(listener: OnSingleResponse<MainMsg>)
    fun getDataInfo(listener: OnSingleResponse<SysMsg>)
    fun getDataWind(listener: OnSingleResponse<WindMsg>)
}