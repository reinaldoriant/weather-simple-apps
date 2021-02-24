package com.ruangaldo.weatherapps.data.remote

import com.ruangaldo.weatherapps.data.model.*
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("/data/2.5/weather?&units=metric")
    fun getWeatherMain(
        @Query("id") city: String,
        @Query("appid") app_id: String
    ): Observable<WeatherMainMsg>

    @GET("/data/2.5/weather?&units=metric")
    fun getWeatherSys(
        @Query("id") city: String,
        @Query("appid") app_id: String
    ): Observable<WeatherSysMsg>

    @GET("/data/2.5/weather?&units=metric")
    fun getWeatherWeather(
        @Query("id") city: String,
        @Query("appid") app_id: String
    ): Observable<WeatherWeatherMsg>

    @GET("/data/2.5/weather?&units=metric")
    fun getWeatherWind(
        @Query("id") city: String,
        @Query("appid") app_id: String
    ): Observable<WeatherWindMsg>

    @GET("/data/2.5/weather?&units=metric")
    fun getWeatherInfo(
        @Query("id") city: String,
        @Query("appid") app_id: String
    ): Observable<WeatherInfoMsg>
}
