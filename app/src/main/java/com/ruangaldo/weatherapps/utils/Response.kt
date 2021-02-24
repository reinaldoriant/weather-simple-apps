package com.ruangaldo.weatherapps.utils


interface OnSingleResponse<T>{
    fun onSuccess(data: T?)
    fun onFailure(error: Error)
}

