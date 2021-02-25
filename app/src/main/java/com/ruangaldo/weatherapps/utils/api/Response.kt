package com.ruangaldo.weatherapps.utils.api



interface OnSingleResponse<T>{
    fun onSuccess(data: T?=null)
    fun onFailure(error: T?=null)
    fun errorMsg(errorMsg:String)
    fun onLoading(loading:Boolean)
}

