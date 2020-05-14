package com.ds.pagoda.data.repositories

import android.util.Log
import androidx.lifecycle.LiveData
import com.ds.pagoda.data.db.DataBase
import com.ds.pagoda.data.db.entities.CurrentWeatherEntity
import com.ds.pagoda.data.network.CurrentWeatherAPI
import com.ds.pagoda.data.network.responces.CurrentWeatherResponce
import retrofit2.Response

class CurrentWeatherRepository(

    private var api: CurrentWeatherAPI,
    private var db: DataBase

){


    suspend fun getCurrentWeather(): Response<CurrentWeatherResponce> {
        val currentWeatherResponce: Response<CurrentWeatherResponce> = api.getCurrentWeather()


        Log.e("list_responce","symbol " + (currentWeatherResponce.body()?.toString() ?: "N/A"))


        return currentWeatherResponce
    }
    
    suspend fun saveCurrentWeatherTODB(currentWeather: CurrentWeatherEntity){
        db.getCurrentWeatherDao().insertCurrentWeather(currentWeather)
    }

    suspend fun getCurrentWeatherFromDB(): LiveData<CurrentWeatherEntity> {
        return db.getCurrentWeatherDao().getCurrentWeather()
    }
}