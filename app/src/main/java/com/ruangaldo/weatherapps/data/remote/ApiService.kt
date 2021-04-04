package com.ruangaldo.weatherapps.data.remote

import com.ruangaldo.weatherapps.data.model.CurrentWeatherMsg
import io.reactivex.Flowable
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("/data/2.5/weather?&units=metric")
    fun getCurrentWeather(
        @Query("id") city: String,
        @Query("appid") app_id: String
    ): Flowable<CurrentWeatherMsg>
}
