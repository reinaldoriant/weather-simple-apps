package com.ruangaldo.weatherapps.data.remote

import com.ruangaldo.weatherapps.data.model.*
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("/data/2.5/weather?&units=metric")
    fun getCurrentWeather(
        @Query("id") city: String,
        @Query("appid") app_id: String
    ): Observable<CurrentWeatherMsg>

/*    @GET("/data/2.5/weather?&units=metric")
    fun getMain(
        @Query("id") city: String,
        @Query("appid") app_id: String
    ): Observable<MainMsg>

    @GET("/data/2.5/weather?&units=metric")
    fun getSys(
        @Query("id") city: String,
        @Query("appid") app_id: String
    ): Observable<SysMsg>

    @GET("/data/2.5/weather?&units=metric")
    fun getWind(
        @Query("id") city: String,
        @Query("appid") app_id: String
    ): Observable<WindMsg>


    @GET("/data/2.5/weather?&units=metric")
    fun getWeather(
        @Query("id") city: String,
        @Query("appid") app_id: String
    ): Observable<WeatherMsg>


    @GET("/data/2.5/weather?&units=metric")
    fun getInfo(
        @Query("id") city: String,
        @Query("appid") app_id: String
    ): Observable<InfoMsg>*/
}
