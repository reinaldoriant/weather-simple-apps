package com.ruangaldo.weatherapps.data.repository

import androidx.lifecycle.LiveData
import com.ruangaldo.weatherapps.data.local.WeatherDao
import com.ruangaldo.weatherapps.data.local.WeatherEntity
import com.ruangaldo.weatherapps.data.model.CurrentWeatherMsg
import com.ruangaldo.weatherapps.data.remote.ApiService
import com.ruangaldo.weatherapps.utils.ui.CITY_CODE
import com.ruangaldo.weatherapps.utils.ui.ID_DB
import com.ruangaldo.weatherapps.utils.ui.KEY
import io.reactivex.Flowable
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class WeatherRepoImp(private val service: ApiService, private val wtDao: WeatherDao) : WeatherRepo {

    override fun getCurrentWeather(): Flowable<CurrentWeatherMsg> =
        service.getCurrentWeather(CITY_CODE, KEY)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())

    fun insertDataLocal(weatherEntity: WeatherEntity): Observable<Boolean> =
        Observable.fromCallable {
            wtDao.insertData(weatherEntity)
            true
        }.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())


    fun getDataById(): LiveData<WeatherEntity> = wtDao.getData(ID_DB)
}

