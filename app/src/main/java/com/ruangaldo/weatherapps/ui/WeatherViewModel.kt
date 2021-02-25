package com.ruangaldo.weatherapps.ui


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ruangaldo.weatherapps.data.local.WeatherEntity
import com.ruangaldo.weatherapps.data.model.*
import com.ruangaldo.weatherapps.data.repository.WeatherRepoImp
import com.ruangaldo.weatherapps.utils.OnSingleResponse

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

    fun getDataInfo() {
        repo.getDataInfo(object : OnSingleResponse<InfoMsg> {
            override fun onSuccess(data: InfoMsg?) {
                dataUpdateAt.value = data!!.dt
                dataCity.value=data.name
            }
            override fun onFailure(error: Error) {
            }
        })
    }

    fun getDataWeather() {
        repo.getDataWeather(object : OnSingleResponse<WeatherMsg> {
            override fun onSuccess(data: WeatherMsg?) {
               dataStatus.value=data!!.weather.first().main
            }
            override fun onFailure(error: Error) {
            }
        })
    }

    fun getDataMain() {
        repo.getDataMain(object : OnSingleResponse<MainMsg> {
            override fun onSuccess(data: MainMsg?) {
                dataTemp.value = data!!.main.temp
                dataTempMin.value=data.main.tempMin
                dataTempMax.value=data.main.tempMax
                dataPressure.value =data.main.pressure
                dataHumidity.value=data.main.humidity
            }

            override fun onFailure(error: Error) {
            }
        })
    }

    fun getDataSys() {
        repo.getDataSys(object : OnSingleResponse<SysMsg> {
            override fun onSuccess(data: SysMsg?) {
                dataSunrise.value = data!!.sys.sunrise
                dataSunset.value =data.sys.sunset
                dataCountry.value=data.sys.country
            }
            override fun onFailure(error: Error) {
                TODO("Not yet implemented")
            }
        })
    }
    fun getDataWind() {
        repo.getDataWind(object : OnSingleResponse<WindMsg> {
            override fun onSuccess(data: WindMsg?) {
                dataWind.value = data!!.wind.speed
            }
            override fun onFailure(error: Error) {
                TODO("Not yet implemented")
            }
        })
    }

}



