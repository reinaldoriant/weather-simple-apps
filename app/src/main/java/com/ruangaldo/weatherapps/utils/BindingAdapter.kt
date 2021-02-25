package com.ruangaldo.weatherapps.utils

import android.widget.TextView
import androidx.databinding.BindingAdapter
import timber.log.Timber
import java.text.SimpleDateFormat
import java.util.*


@BindingAdapter("dataCity")
fun dataCity(view: TextView, text: String?) {
    view.text = ("$text,")
    Timber.tag("cek dataCity").i(text.toString())
}

@BindingAdapter("dataCountry")
fun dataCountry(view: TextView, text: String?) {
    view.text = text
    Timber.tag("cek dataCountry").i(text.toString())
}


@BindingAdapter("dataUpdateAt")
fun dataUpdateAt(view: TextView, text: Int) {
    view.text = text.toLong().dateFormat()
    Timber.tag("cek dataUpdateAt").i(text.toLong().dateFormat())
}

@BindingAdapter("dataStatus")
fun dataStatus(view: TextView, text: String?) {
    view.text = text
    Timber.tag("cek dataStatus").i(text.toString())
}

@BindingAdapter("dataTemp")
fun dataTemp(view: TextView, text: Double) {
    view.text = text.tempFormat()
    Timber.tag("cek dataTemp").i(text.toString())
}

@BindingAdapter("dataTempMin")
fun dataTempMin(view: TextView, text: Double) {
    view.text = text.tempFormat()
    Timber.tag("cek dataTempMin").i(text.toString())
}

@BindingAdapter("dataTempMax")
fun dataTempMax(view: TextView, text: Double) {
    view.text = text.tempFormat()
    Timber.tag("cek dataTempMax").i(text.toString())
}

@BindingAdapter("dataSunrise")
fun dataSunrise(view: TextView, text: Long) {
    view.text = text.timeFormat()
    Timber.tag("cek dataSunrise").i(text.toString())
}

@BindingAdapter("dataSunset")
fun dataSunset(view: TextView, text: Long) {
    view.text = text.timeFormat()
    Timber.tag("cek dataSunset").i(text.toString())
}

@BindingAdapter("dataWind")
fun dataWind(view: TextView, text: Double) {
    view.text = text.toString()
    Timber.tag("cek dataWind").i(text.toString())
}

@BindingAdapter("dataPressure")
fun dataPressure(view: TextView, text: Int) {
    view.text = text.toString()
    Timber.tag("cek dataPressure").i(text.toString())
}

@BindingAdapter("dataHumidity")
fun dataHumidity(view: TextView, text: Int) {
    view.text = text.toString()
    Timber.tag("cek dataHumidity").i(text.toString())
}

