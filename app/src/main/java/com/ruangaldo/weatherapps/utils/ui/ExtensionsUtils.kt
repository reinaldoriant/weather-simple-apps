package com.ruangaldo.weatherapps.utils.ui

import timber.log.Timber
import java.text.SimpleDateFormat
import java.util.*

fun Long.dateFormat():String {
    return SimpleDateFormat("dd/MM/yyyy hh:mm a", Locale.ENGLISH).format(Date(this * 1000))
}
fun Long.timeFormat():String {
    return SimpleDateFormat("hh:mm a", Locale.ENGLISH).format(Date(this * 1000))
}

fun Double.tempFormat():String {
    return String.format("%.0f",this) + " \u2103"
}

fun logCat(tag:String,string:String,error:Throwable?=null){
    if (error==null) Timber.tag(tag).i(string)
    else Timber.tag(tag).e(string)
}
