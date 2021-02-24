package com.ruangaldo.weatherapps.utils

import android.widget.TextView
import androidx.databinding.BindingAdapter


@BindingAdapter("dataTemp")
fun dataTemp(view: TextView, text: CharSequence?) {
    view.text = text
}
