package com.ruangaldo.weatherapps.ui

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.ruangaldo.weatherapps.R
import com.ruangaldo.weatherapps.databinding.ActivityWeatherBinding
import com.ruangaldo.weatherapps.utils.App

import org.koin.android.viewmodel.ext.android.viewModel
import timber.log.Timber


class WeatherActivity : AppCompatActivity() {
    private lateinit var binding: ActivityWeatherBinding
    private val weatherViewModel: WeatherViewModel by viewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_weather)
        binding.viewModel=weatherViewModel
        binding.lifecycleOwner = this
        runViewModel()
        weatherViewModel.errorMessage.observe(this,{
            Toast.makeText(this,it,Toast.LENGTH_SHORT).show()
            Timber.d(it)
        })
        binding.swipeRefresh.setOnRefreshListener {
            runViewModel()
            binding.swipeRefresh.isRefreshing = false
        }


    }
    private fun runViewModel(){
        weatherViewModel.getCurrentWeather()
        Timber.i("View Model run success")
    }

}
