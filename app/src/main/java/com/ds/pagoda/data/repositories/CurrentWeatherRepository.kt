package com.ds.pagoda.data.repositories

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.ds.pagoda.data.network.CurrentWeatherAPI
import com.ds.pagoda.data.network.responces.CurrentWeatherResponce
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CurrentWeatherRepository {

    suspend fun getCurrentWeather(): Response<CurrentWeatherResponce> {

        val currentWeatherResponce: Response<CurrentWeatherResponce> = CurrentWeatherAPI().getCurrentWeather()


        Log.e("list_responce","symbol " + (currentWeatherResponce.body()?.toString() ?: "N/A"))



        return currentWeatherResponce
    }
}