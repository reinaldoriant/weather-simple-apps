package com.ruangaldo.weatherapps.utils

import retrofit2.HttpException
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
