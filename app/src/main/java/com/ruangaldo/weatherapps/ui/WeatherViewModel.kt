package com.ruangaldo.weatherapps.ui


import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ruangaldo.weatherapps.data.repository.WeatherRepository

class WeatherViewModel(private var repo: WeatherRepository) : ViewModel() {
    val dataTemp = MutableLiveData<String>()
    fun processDataMain()=repo.getWeatherMain()
    fun getDataTemp(){
        val data=repo.dataMain.value
        Log.e("Cek",data.toString())
       dataTemp.value= repo.dataMain.value
    }

}


