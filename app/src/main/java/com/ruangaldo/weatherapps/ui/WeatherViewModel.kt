package com.ruangaldo.weatherapps.ui


import androidx.lifecycle.*
import com.ruangaldo.weatherapps.data.local.WeatherEntity
import com.ruangaldo.weatherapps.data.model.CurrentWeatherMsg
import com.ruangaldo.weatherapps.data.repository.WeatherRepoImp
import com.ruangaldo.weatherapps.utils.api.OnSingleResponse
import com.ruangaldo.weatherapps.utils.ui.logCat


class WeatherViewModel(private var repo: WeatherRepoImp) : ViewModel() {

    val errorMessage = MutableLiveData<String>()
    val dataAll = MutableLiveData<WeatherEntity>()
    val loadingData= MutableLiveData<Boolean>()

    fun getCurrentWeather() {
        repo.getCurrentWeather(object : OnSingleResponse<CurrentWeatherMsg> {
            override fun onSuccess(data: CurrentWeatherMsg?) {}
            override fun onFailure(error: CurrentWeatherMsg?) {}
            override fun onLoading(loading: Boolean) {
                loadingData.value=loading
            }
            override fun errorMsg(errorMsg: String) {
                errorMessage.value = errorMsg
            }
        })
    }

    fun setDataAll(dataAll:WeatherEntity){
        this.dataAll.value=dataAll
        logCat("Success",dataAll.toString())
    }
    fun getDataById(): LiveData<WeatherEntity> {
        return repo.getDataById()
    }
}
