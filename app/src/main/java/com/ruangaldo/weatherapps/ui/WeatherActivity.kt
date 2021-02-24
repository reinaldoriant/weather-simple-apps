package com.ruangaldo.weatherapps.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.ruangaldo.weatherapps.R
import com.ruangaldo.weatherapps.databinding.ActivityWeatherBinding
import org.koin.android.viewmodel.ext.android.viewModel


class WeatherActivity : AppCompatActivity() {
    private lateinit var binding: ActivityWeatherBinding
    private val weatherViewModel: WeatherViewModel by viewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = DataBindingUtil.setContentView(this,R.layout.activity_weather)
        binding.viewModel=weatherViewModel
        super.onCreate(savedInstanceState)
        weatherViewModel.processDataMain()
        weatherViewModel.getDataTemp()
    }
}