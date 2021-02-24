package com.ruangaldo.weatherapps.utils

import android.util.Log
import android.widget.TextView
import androidx.databinding.BindingAdapter

@BindingAdapter("dataTemp")
fun dataTemp(view: TextView, text: String?) {
    view.text = text
    Log.e("DataBinding Check", text.toString())
}

@BindingAdapter("dataSunrise")
fun dataSunrise(view: TextView, text: String?) {
    view.text = text
    Log.e("DataBinding Check", text.toString())
}

@BindingAdapter("dataSunset")
fun dataSunset(view: TextView, text: String?) {
    view.text = text
    Log.e("DataBinding Check", text.toString())
}

@BindingAdapter("dataWind")
fun dataWind(view: TextView, text: String?) {
    view.text = text
    Log.e("DataBinding Check", text.toString())
}

@BindingAdapter("dataPressure")
fun dataPressure(view: TextView, text: String?) {
    view.text = text
    Log.e("DataBinding Check", text.toString())
}

@BindingAdapter("dataHumidity")
fun dataHumidity(view: TextView, text: String?) {
    view.text = text
    Log.e("DataBinding Check", text.toString())
}

