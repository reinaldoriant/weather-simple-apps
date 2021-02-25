package com.ruangaldo.weatherapps.data.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "dataWeather")
data class WeatherEntity(
    @PrimaryKey(autoGenerate = true) val id: Int? = null,
    @ColumnInfo(name = "city") val city: String? = null,
    @ColumnInfo(name = "country") val country: String? = null,
    @ColumnInfo(name = "update_at") val update_at: String? = null,
    @ColumnInfo(name = "temp") val temp: String? = null,
    @ColumnInfo(name = "temp_min") val temp_min: String? = null,
    @ColumnInfo(name = "temp_max") val temp_max: String? = null,
    @ColumnInfo(name = "sunrise") val sunrise: String? = null,
    @ColumnInfo(name = "sunset") val sunset: String? = null,
    @ColumnInfo(name = "wind") val wind: String? = null,
    @ColumnInfo(name = "pressure") val pressure: String? = null,
    @ColumnInfo(name = "humidity") val humidity: String? = null,
    )
