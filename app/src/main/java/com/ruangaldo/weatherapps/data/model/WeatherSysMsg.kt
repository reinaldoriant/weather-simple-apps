package com.ruangaldo.weatherapps.data.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class WeatherSysMsg(
    @Json(name = "sys")
    val sys: Sys
) {
    data class Sys(
        @Json(name = "country")
        val country: String,
        @Json(name = "id")
        val id: Int,
        @Json(name = "sunrise")
        val sunrise: Int,
        @Json(name = "sunset")
        val sunset: Int,
        @Json(name = "type")
        val type: Int
    )
}