package com.ruangaldo.weatherapps.data.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.ruangaldo.weatherapps.data.model.*
import com.ruangaldo.weatherapps.data.remote.ApiService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class WeatherRepository(private val service: ApiService) {
    private var disposable: Disposable? = null
    private val city = "1642911"
    private val key = "b794698a46abe2ac24c44a69ad0ef1ca"
    var dataMain = MutableLiveData<WeatherMainMsg.Main>()
    var dataSys = MutableLiveData<WeatherSysMsg.Sys>()
    var dataWind = MutableLiveData<WeatherWindMsg.Wind>()
    var dataWeather = MutableLiveData<List<WeatherWeatherMsg.Weather>>()
    var dataInfo = MutableLiveData<WeatherInfoMsg>()

    fun getWeatherMain() {
        disposable = service.getWeatherMain(city, key)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                dataMain.value = it.main
                Log.e("Test Data", it.main.temp.toString())
            }, {
                Log.e("Error", it.toString())
                it.printStackTrace()
            })
    }

    fun getWeatherSys() {
        disposable = service.getWeatherSys(city, key)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                dataSys.value = it.sys
                Log.e("Test Data", it.sys.sunrise.toString())
            }, {
                Log.e("Error", it.toString())
                it.printStackTrace()
            })
    }

    fun getWeatherWeather() {
        disposable = service.getWeatherWeather(city, key)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                dataWeather.value = it.weather
                Log.e("Test Data", it.weather[0].toString())
            }, {
                Log.e("Error", it.toString())
                it.printStackTrace()
            })
    }

    fun getWind() {
        disposable = service.getWeatherWind(city, key)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                dataWind.value = it.wind
                Log.e("Test Data", it.wind.speed.toString())
            }, {
                Log.e("Error", it.toString())
                it.printStackTrace()
            })
    }

    fun getInfo() {
        disposable = service.getWeatherInfo(city, key)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                dataInfo.value = it
                Log.e("Test Data", it.name)
            }, {
                Log.e("Error", it.toString())
                it.printStackTrace()
            })
    }
}