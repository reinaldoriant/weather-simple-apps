package com.ruangaldo.weatherapps.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query

@Dao
interface WeatherDao {
    @Insert(onConflict = REPLACE)
    fun insertData(dataWeather: WeatherEntity)

    @Query("SELECT * FROM dataWeather WHERE id = :key")
    fun getData(key: Int): LiveData<WeatherEntity>
}