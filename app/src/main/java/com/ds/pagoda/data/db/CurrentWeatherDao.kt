package com.ds.pagoda.data.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.ds.pagoda.data.db.entities.CurrentWeatherEntity

@Dao
interface CurrentWeatherDao {

    @Insert
    suspend fun insertCurrentWeather(currentWeatherEntity: CurrentWeatherEntity)

    @Query("SELECT * FROM current_weather")
    fun getCurrentWeather() : LiveData<CurrentWeatherEntity>
}