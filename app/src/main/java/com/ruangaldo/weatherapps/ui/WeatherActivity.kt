package com.ruangaldo.weatherapps.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.ruangaldo.weatherapps.R
import com.ruangaldo.weatherapps.data.remote.ApiModule
import org.koin.android.ext.android.inject
import org.koin.android.viewmodel.ext.android.viewModel


class WeatherActivity : AppCompatActivity() {

    private val viewModel: WeatherViewModel by viewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weather)
        /*      val weatherViewModel: WeatherViewModel by viewModel()*/
        val temp = findViewById<TextView>(R.id.tv_Temp)
        viewModel.processDataMain()
        viewModel.getDataMain().observe(this, {
            temp.text = (it.temp.toString() + "\u2103")
        }
        )
    }
}
