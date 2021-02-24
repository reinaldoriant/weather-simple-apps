package com.ruangaldo.weatherapps.ui


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ruangaldo.weatherapps.data.model.MainMsg
import com.ruangaldo.weatherapps.data.model.SysMsg
import com.ruangaldo.weatherapps.data.model.WindMsg
import com.ruangaldo.weatherapps.data.repository.WeatherRepoImp
import com.ruangaldo.weatherapps.utils.OnSingleResponse
import java.text.SimpleDateFormat
import java.util.*

class WeatherViewModel(private var repo: WeatherRepoImp) : ViewModel() {
    val dataTemp = MutableLiveData<String>()
    val dataSunrise = MutableLiveData<String>()
    val dataSunset = MutableLiveData<String>()
    val dataWind = MutableLiveData<String>()
    val dataPressure = MutableLiveData<String>()
    val dataHumidity = MutableLiveData<String>()

    fun getDataMain() {
        repo.getDataMain(object : OnSingleResponse<MainMsg> {
            override fun onSuccess(data: MainMsg?) {
                dataTemp.value = data!!.main.temp.toString()
                dataPressure.value =data.main.pressure.toString()
                dataHumidity.value=data.main.humidity.toString()
            }

            override fun onFailure(error: Error) {
            }
        })
    }

    fun getDataSys() {
        repo.getDataSys(object : OnSingleResponse<SysMsg> {
            override fun onSuccess(data: SysMsg?) {
                val timeSunrise = data!!.sys.sunrise
                dataSunrise.value =
                    SimpleDateFormat("hh:mm a", Locale.ENGLISH).format(Date(timeSunrise * 1000))
                val timeSunset = data.sys.sunset
                dataSunset.value =
                    SimpleDateFormat("hh:mm a", Locale.ENGLISH).format(Date(timeSunset * 1000))
            }
            override fun onFailure(error: Error) {
                TODO("Not yet implemented")
            }
        })
    }
    fun getDataWind() {
        repo.getDataWind(object : OnSingleResponse<WindMsg> {
            override fun onSuccess(data: WindMsg?) {
                dataWind.value = data!!.wind.speed.toString()
            }
            override fun onFailure(error: Error) {
                TODO("Not yet implemented")
            }
        })
    }

}



