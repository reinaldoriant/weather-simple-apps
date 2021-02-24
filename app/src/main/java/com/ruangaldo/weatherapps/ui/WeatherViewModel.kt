package com.ruangaldo.weatherapps.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.ruangaldo.weatherapps.data.model.WeatherMainMsg
import com.ruangaldo.weatherapps.data.remote.ApiService
import com.ruangaldo.weatherapps.data.repository.WeatherRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class WeatherViewModel(private var repo: WeatherRepository) : ViewModel() {
    fun getDataMain()= repo.dataMain
    fun processDataMain()=repo.getWeatherMain()
}

