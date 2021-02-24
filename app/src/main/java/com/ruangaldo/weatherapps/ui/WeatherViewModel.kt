package com.ruangaldo.weatherapps.ui

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.ruangaldo.weatherapps.data.model.WeatherMsg
import com.ruangaldo.weatherapps.data.remote.ApiService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class WeatherViewModel(private var service: ApiService) : ViewModel() {
    private var disposable: Disposable? = null
    var data = MutableLiveData<WeatherMsg.Main>()
    fun getWeather() {
        val city = "1642911"
        val key = "b794698a46abe2ac24c44a69ad0ef1ca"
        disposable = service.getWeatherByCity(city,key)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                data.value = it.main
                Log.e("Apasih",it.main.temp.toString())
            }, {
                Log.e("Asek",it.toString())
                it.printStackTrace()
            })
    }
    @Suppress("UNCHECKED_CAST")
    class Factory(private val service: ApiService) : ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return WeatherViewModel(service) as T
        }
    }
}

