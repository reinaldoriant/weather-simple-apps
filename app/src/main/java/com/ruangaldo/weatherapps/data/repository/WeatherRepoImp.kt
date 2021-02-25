package com.ruangaldo.weatherapps.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.LiveDataReactiveStreams
import androidx.lifecycle.map
import com.ruangaldo.weatherapps.data.local.WeatherDao
import com.ruangaldo.weatherapps.data.local.WeatherEntity
import com.ruangaldo.weatherapps.data.model.CurrentWeatherMsg
import com.ruangaldo.weatherapps.data.remote.ApiService
import com.ruangaldo.weatherapps.utils.OnSingleResponse
import com.ruangaldo.weatherapps.utils.getErrorMessage
import com.ruangaldo.weatherapps.utils.getErrorThrowableCode
import com.ruangaldo.weatherapps.utils.getServiceErrorMsg
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import timber.log.Timber


class WeatherRepoImp(private val service: ApiService, private val wtDao: WeatherDao) : WeatherRepo {

    private var disposable: Disposable? = null
    private val compositeDisposable = CompositeDisposable()
    private val city = "1642911"
    private val key = "b794698a46abe2ac24c44a69ad0ef1ca"


    override fun getCurrentWeather(listener: OnSingleResponse<CurrentWeatherMsg>) {
        disposable = service.getCurrentWeather(city, key)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                listener.onSuccess(it)
                val dataField = WeatherEntity(
                    14045,
                    it.name,
                    it.sys.country,
                    it.dt,
                    it.weather.first().main,
                    it.main.temp,
                    it.main.tempMin,
                    it.main.tempMax,
                    it.sys.sunrise,
                    it.sys.sunset,
                    it.wind.speed,
                    it.main.pressure,
                    it.main.humidity
                )
                insertDataLocal(dataField)
                Timber.tag("Get from API").i(it.toString())
                Timber.tag("Send to DB Local").i(dataField.toString())
            }, { it ->
                val msg=getErrorMessage(it.getServiceErrorMsg(),it.getErrorThrowableCode())
                if (msg=="Unknown Error"){
                    getDataById(14045).map {dataLocal->
                        listener.onFailure(dataLocal)
                    }
                }
                Timber.tag("Get Error").e(msg)
                it.printStackTrace()
            })
    }

    private fun insertDataLocal(weatherEntity: WeatherEntity) {
        compositeDisposable.add(Observable.fromCallable { wtDao.insertData(weatherEntity) }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe())
        Timber.tag("Insert to DB Local").i(weatherEntity.toString())
    }

    private fun getDataById(lastUpdate: Int): LiveData<WeatherEntity> {
        return LiveDataReactiveStreams.fromPublisher(
            wtDao.getData(lastUpdate)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.computation())
        )
    }
}

