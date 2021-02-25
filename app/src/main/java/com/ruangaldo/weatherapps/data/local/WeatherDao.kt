package com.ruangaldo.weatherapps.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import androidx.room.Update
import io.reactivex.Flowable

@Dao
interface WeatherDao {
    @Insert(onConflict = REPLACE)
    fun insertData(dataWeather: WeatherEntity)

    @Query("SELECT * FROM dataWeather WHERE update_at = :lastUpdate")
    fun getData(lastUpdate:Int): Flowable<WeatherEntity>
}