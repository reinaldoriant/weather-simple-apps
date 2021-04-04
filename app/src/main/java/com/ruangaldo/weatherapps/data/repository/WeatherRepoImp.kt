package com.ruangaldo.weatherapps.data.repository

import com.ruangaldo.weatherapps.data.local.WeatherDao
import com.ruangaldo.weatherapps.data.model.CurrentWeatherMsg
import com.ruangaldo.weatherapps.data.remote.ApiService
import com.ruangaldo.weatherapps.utils.ui.CITY_CODE
import com.ruangaldo.weatherapps.utils.ui.KEY
import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class WeatherRepoImp(private val service: ApiService, private val wtDao: WeatherDao) : WeatherRepo {

    override fun getCurrentWeather(): Flowable<CurrentWeatherMsg> =
        service.getCurrentWeather(CITY_CODE, KEY)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    /*service.getCurrentWeather(CITY_CODE, KEY)
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())*/
    /*.subscribe({
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
}*/

    /*private fun insertDataLocal(weatherEntity: WeatherEntity) {
        Observable.fromCallable { wtDao.insertData(weatherEntity) }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe()
    }*/

    /*fun getDataById(): LiveData<WeatherEntity> {
        return LiveDataReactiveStreams.fromPublisher(
            wtDao.getData(ID_DB)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.computation())
        )
    }*/
}

