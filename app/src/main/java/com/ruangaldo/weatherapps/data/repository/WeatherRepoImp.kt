package com.ruangaldo.weatherapps.data.repository

import android.util.Log
import androidx.lifecycle.LiveData
import com.ruangaldo.weatherapps.data.local.WeatherDao
import com.ruangaldo.weatherapps.data.local.WeatherEntity
import com.ruangaldo.weatherapps.data.model.*
import com.ruangaldo.weatherapps.data.remote.ApiService
import com.ruangaldo.weatherapps.utils.OnSingleResponse
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import androidx.lifecycle.LiveDataReactiveStreams


class WeatherRepoImp(private val service: ApiService, private val wtDao: WeatherDao) : WeatherRepo {

    private var disposable: Disposable? = null
    private val compositeDisposable = CompositeDisposable()
    private val city = "1642911"
    private val key = "b794698a46abe2ac24c44a69ad0ef1ca"
    var dataArray = mutableListOf<Any>()

    override fun getCurrentWeather(listener: OnSingleResponse<CurrentWeatherMsg>) {
        disposable = service.getCurrentWeather(city, key)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                listener.onSuccess(it)
                dataArray.add(it)
                Log.e("Test Data", it.sys.sunrise.toString())
            }, {
                Log.e("Error", it.toString())
                it.printStackTrace()
            })
    }

    fun insertDataLocal(weatherEntity: WeatherEntity) {
        compositeDisposable.add(Observable.fromCallable { wtDao.insertData(weatherEntity) }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe())
    }

    fun getDataById(lastUpdate: Int): LiveData<WeatherEntity> {
        return LiveDataReactiveStreams.fromPublisher(
            wtDao.getData(lastUpdate)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.computation())
        )
    }
}

