package com.ruangaldo.weatherapps.ui


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.ruangaldo.weatherapps.data.local.WeatherEntity
import com.ruangaldo.weatherapps.data.model.CurrentWeatherMsg
import com.ruangaldo.weatherapps.data.repository.WeatherRepoImp
import com.ruangaldo.weatherapps.utils.OnSingleResponse
import timber.log.Timber

class WeatherViewModel(private var repo: WeatherRepoImp) : ViewModel() {

    val dataCity = MutableLiveData<String>()
    val dataCountry = MutableLiveData<String>()
    val dataUpdateAt = MutableLiveData<Int>()
    val dataStatus = MutableLiveData<String>()
    val dataTemp = MutableLiveData<Double>()
    val dataTempMin = MutableLiveData<Double>()
    val dataTempMax = MutableLiveData<Double>()
    val dataSunrise = MutableLiveData<Long>()
    val dataSunset = MutableLiveData<Long>()
    val dataWind = MutableLiveData<Double>()
    val dataPressure = MutableLiveData<Int>()
    val dataHumidity = MutableLiveData<Int>()
    val errorMessage= MutableLiveData<String>()
    fun getCurrentWeather() {
        repo.getCurrentWeather(object : OnSingleResponse<CurrentWeatherMsg> {
            override fun onSuccess(data: CurrentWeatherMsg?) {
                dataUpdateAt.value = data!!.dt
                dataCity.value = data.name
                dataStatus.value = data.weather.first().main
                dataTemp.value = data.main.temp
                dataTempMin.value = data.main.tempMin
                dataTempMax.value = data.main.tempMax
                dataPressure.value = data.main.pressure
                dataHumidity.value = data.main.humidity
                dataSunrise.value = data.sys.sunrise
                dataSunset.value = data.sys.sunset
                dataCountry.value = data.sys.country
                dataWind.value = data.wind.speed
                Timber.tag("get data from api").i(data.toString())
            }

            override fun onFailure(error: WeatherEntity) {
                dataUpdateAt.value = error.update_at
                dataCity.value = error.city
                dataStatus.value = error.status
                dataTemp.value = error.temp
                dataTempMin.value = error.temp_min
                dataTempMax.value = error.temp_max
                dataPressure.value = error.pressure
                dataHumidity.value = error.humidity
                dataSunrise.value = error.sunrise
                dataSunset.value = error.sunset
                dataCountry.value = error.country
                dataWind.value = error.wind
            }

            override fun errorMsg(errorMsg: String) {
                errorMessage.value=errorMsg
                Timber.tag("cek error msg").e(errorMsg)
            }


        })


    }
}



