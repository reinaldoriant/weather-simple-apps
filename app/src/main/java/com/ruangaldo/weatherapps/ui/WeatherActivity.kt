package com.ruangaldo.weatherapps.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.ruangaldo.weatherapps.R
import com.ruangaldo.weatherapps.data.remote.ApiModule


class WeatherActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weather)
        /*      val weatherViewModel: WeatherViewModel by viewModel()*/
        val factory = WeatherViewModel.Factory(ApiModule.service)
        val viewModel = ViewModelProvider(this, factory)[WeatherViewModel::class.java]
        viewModel.getWeather()
        val temp = findViewById<TextView>(R.id.tv_Temp)
        viewModel.data.observe(
            this, {
                temp.text = (it.temp.toString()+ "\u2103")
            }
        )
    }
}