package com.ds.pagoda.data.network

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface CurrentWeatherAPI {
    @GET("weather?q=San%20Fransisco,us&appid=439d4b804bc8187953eb36d2a8c26a02")
    fun getCurrentWeather(): Call<ResponseBody>

    companion object{
        operator fun invoke(): CurrentWeatherAPI {
            return Retrofit.Builder()
                .baseUrl("https://samples.openweathermap.org/data/2.5/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(CurrentWeatherAPI::class.java)
        }
    }
}