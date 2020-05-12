package com.ds.pagoda.data.repositories

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.ds.pagoda.data.network.CurrentWeatherAPI
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CurrentWeatherRepository {

    fun getCurrentWeather(): LiveData<String> {

        val currentWeatherResponce = MutableLiveData<String>()

        CurrentWeatherAPI().getCurrentWeather().enqueue(object : Callback<ResponseBody>{
            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {

            }

            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                currentWeatherResponce.value = response.body()?.toString()
            }
        })

        return currentWeatherResponce
    }
}