package com.ruangaldo.weatherapps.data.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.ruangaldo.weatherapps.data.model.*
import com.ruangaldo.weatherapps.data.remote.ApiService
import com.ruangaldo.weatherapps.utils.OnSingleResponse
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class WeatherRepoImp(private val service: ApiService) : WeatherRepo {
    private var disposable: Disposable? = null
    private val city = "1642911"
    private val key = "b794698a46abe2ac24c44a69ad0ef1ca"

    override fun getDataMain(listener: OnSingleResponse<String>) {
        disposable = service.getWeatherMain(city, key)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                listener.onSuccess(it.main.temp.toString())
                Log.e("Test Data", it.main.temp.toString())
            }, {
                Log.e("Error", it.toString())
                it.printStackTrace()
            })
    }
}