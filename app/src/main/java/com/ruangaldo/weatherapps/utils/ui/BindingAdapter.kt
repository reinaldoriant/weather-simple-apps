package com.ruangaldo.weatherapps.utils.ui

import android.widget.TextView
import androidx.databinding.BindingAdapter


@BindingAdapter("dataCity")
fun dataCity(view: TextView, text: String?) {
    view.text = ("$text,")
    logCat("check dataCity",text.toString())
}

@BindingAdapter("dataCountry")
fun dataCountry(view: TextView, text: String?) {
    view.text = text
    logCat("check dataCountry",text.toString())
}


@BindingAdapter("dataUpdateAt")
fun dataUpdateAt(view: TextView, text: Int) {
    view.text = text.toLong().dateFormat()
    logCat("check dataUpdateAt",text.toLong().dateFormat())
}

@BindingAdapter("dataStatus")
fun dataStatus(view: TextView, text: String?) {
    view.text = text
    logCat("check dataStatus",text.toString())
}

@BindingAdapter("dataTemp")
fun dataTemp(view: TextView, text: Double) {
    view.text = text.tempFormat()
    logCat("check dataTemp",text.toString())
}

@BindingAdapter("dataTempMin")
fun dataTempMin(view: TextView, text: Double) {
    view.text = text.tempFormat()
    logCat("check dataTempMin",text.toString())
}

@BindingAdapter("dataTempMax")
fun dataTempMax(view: TextView, text: Double) {
    view.text = text.tempFormat()
    logCat("check dataTempMax",text.toString())
}

@BindingAdapter("dataSunrise")
fun dataSunrise(view: TextView, text: Long) {
    view.text = text.timeFormat()
    logCat("check dataSunrise",text.toString())
}

@BindingAdapter("dataSunset")
fun dataSunset(view: TextView, text: Long) {
    view.text = text.timeFormat()
    logCat("check dataSunset",text.toString())
}

@BindingAdapter("dataWind")
fun dataWind(view: TextView, text: Double) {
    view.text = text.toString()
    logCat("check dataWind",text.toString())
}

@BindingAdapter("dataPressure")
fun dataPressure(view: TextView, text: Int) {
    view.text = text.toString()
    logCat("check dataPressure",text.toString())
}

@BindingAdapter("dataHumidity")
fun dataHumidity(view: TextView, text: Int) {
    view.text = text.toString()
    logCat("check dataHumidity",text.toString())
}

