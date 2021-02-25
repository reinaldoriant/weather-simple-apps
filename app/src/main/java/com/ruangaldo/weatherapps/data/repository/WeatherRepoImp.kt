package com.ruangaldo.weatherapps.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.LiveDataReactiveStreams
import com.ruangaldo.weatherapps.data.local.WeatherDao
import com.ruangaldo.weatherapps.data.local.WeatherEntity
import com.ruangaldo.weatherapps.data.model.CurrentWeatherMsg
import com.ruangaldo.weatherapps.data.remote.ApiService
import com.ruangaldo.weatherapps.utils.api.OnSingleResponse
import com.ruangaldo.weatherapps.utils.api.getErrorMessage
import com.ruangaldo.weatherapps.utils.api.getErrorThrowableCode
import com.ruangaldo.weatherapps.utils.api.getServiceErrorMsg
import com.ruangaldo.weatherapps.utils.ui.*
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class WeatherRepoImp(private val service: ApiService, private val wtDao: WeatherDao) : WeatherRepo {

    private var disposable: Disposable? = null
    private val compositeDisposable = CompositeDisposable()

    override fun getCurrentWeather(listener: OnSingleResponse<CurrentWeatherMsg>) {
        listener.onLoading(true)
        disposable = service.getCurrentWeather(CITY_CODE, KEY)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                val dataField = it.backToEntity()
                insertDataLocal(dataField)
                listener.onSuccess()
                listener.onLoading(false)
                logCat("Success", it.toString())
            }) {
                val msg = getErrorMessage(it.getServiceErrorMsg(), it.getErrorThrowableCode())
                if (msg == UNKNOWN_ERR) {
                    listener.errorMsg(CHECK_INT)
                } else {
                    listener.errorMsg(msg)
                }
                listener.onFailure()
                listener.onLoading(false)
                logCat("WeatherRepoImp", "error from get API", it)
                it.printStackTrace()
            }
    }

    private fun insertDataLocal(weatherEntity: WeatherEntity) {
        compositeDisposable.add(Observable.fromCallable { wtDao.insertData(weatherEntity) }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe())
        logCat("Success", weatherEntity.toString())
    }

    fun getDataById(): LiveData<WeatherEntity> {
        return LiveDataReactiveStreams.fromPublisher(
            wtDao.getData(ID_DB)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.computation())
        )
    }
}

