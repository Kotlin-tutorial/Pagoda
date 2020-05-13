package com.ds.pagoda.ui.fragments

import androidx.lifecycle.ViewModel
import com.ds.pagoda.data.network.responces.CurrentWeatherResponce
import com.ds.pagoda.data.repositories.CurrentWeatherRepository
import com.ds.pagoda.utils.Coroutines
import retrofit2.Response

class CurrentWeatherFragmentViewModel: ViewModel() {

    fun getCurrentWeather(){
        Coroutines.backGround{
            val currentWeatherResponce : Response<CurrentWeatherResponce> = CurrentWeatherRepository().getCurrentWeather()
        }
    }
}