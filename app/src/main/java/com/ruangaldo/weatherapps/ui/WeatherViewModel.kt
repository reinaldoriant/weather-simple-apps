package com.ruangaldo.weatherapps.ui


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ruangaldo.weatherapps.data.local.WeatherEntity
import com.ruangaldo.weatherapps.data.repository.WeatherRepoImp
import com.ruangaldo.weatherapps.utils.api.getErrorMessage
import com.ruangaldo.weatherapps.utils.api.getErrorThrowableCode
import com.ruangaldo.weatherapps.utils.api.getServiceErrorMsg
import com.ruangaldo.weatherapps.utils.ui.CHECK_INT
import com.ruangaldo.weatherapps.utils.ui.UNKNOWN_ERR
import com.ruangaldo.weatherapps.utils.ui.logCat
import io.reactivex.disposables.CompositeDisposable


class WeatherViewModel(private var repo: WeatherRepoImp) : ViewModel() {

    val errorMessage = MutableLiveData<String>()
    val dataAll = MutableLiveData<WeatherEntity>()
    val loadingData = MutableLiveData<Boolean>()
    val dataById get() = repo.getDataById()
    private val compositeDisposable = CompositeDisposable()

    fun getCurrentWeather() {
        compositeDisposable.add(
            repo.getCurrentWeather()
                .doOnSubscribe {
                    loadingData.value = true
                }
                .doOnTerminate {
                    loadingData.value = false
                }
                .subscribe({
                    val weatherEntity = it.backToEntity()
                    dataAll.value = weatherEntity
                    insertDataLocal(weatherEntity)
                }, {
                    var msg = getErrorMessage(it.getServiceErrorMsg(), it.getErrorThrowableCode())
                    if (msg == UNKNOWN_ERR) {
                        msg = CHECK_INT
                    }
                    errorMessage.value = msg
                })
        )
    }

    private fun insertDataLocal(weatherEntity: WeatherEntity) {
        compositeDisposable.add(
            repo.insertDataLocal(weatherEntity)
                .doOnError {
                    logCat("Insert Data Local", it.message.toString())
                }
                .subscribe()
        )
    }

    fun setDataAll(dataAll: WeatherEntity) {
        this.dataAll.value = dataAll
        logCat("Success", dataAll.toString())
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }
}
