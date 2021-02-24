package com.ruangaldo.weatherapps.ui


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ruangaldo.weatherapps.data.repository.WeatherRepoImp
import com.ruangaldo.weatherapps.utils.OnSingleResponse

class WeatherViewModel(private var repo: WeatherRepoImp) : ViewModel() {
    val dataTemp = MutableLiveData<String>()

    fun getDataMain(){
        repo.getDataMain(object :OnSingleResponse<String>{
            override fun onSuccess(data: String?) {
                dataTemp.value = data
            }
            override fun onFailure(error: Error) {
                TODO("Not yet implemented")
            }

        })
    }

}


