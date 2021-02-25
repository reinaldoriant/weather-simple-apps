package com.ruangaldo.weatherapps.utils

import androidx.lifecycle.LiveData
import com.ruangaldo.weatherapps.data.local.WeatherEntity


interface OnSingleResponse<T>{
    fun onSuccess(data: T?)
    fun onFailure(error: WeatherEntity)
    fun errorMsg(errorMsg:String)
}

