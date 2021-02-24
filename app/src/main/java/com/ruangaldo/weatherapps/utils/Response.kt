package com.ruangaldo.weatherapps.utils


interface OnSingleResponse<T>{
    fun onSuccess(data: T?)
    fun onFailure(error: Error)
}

interface OnArrayResponse<T>{
    fun onSuccess(data: List<T>?)
    fun onFailure(error: Error)
}