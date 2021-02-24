package com.ruangaldo.weatherapps.data.remote

import com.ruangaldo.weatherapps.data.model.WeatherMsg
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("/data/2.5/weather?&units=metric")
    fun getWeatherByCity(
        @Query("id") city: String,
        @Query("appid") app_id: String
    ): Observable<WeatherMsg>


}
