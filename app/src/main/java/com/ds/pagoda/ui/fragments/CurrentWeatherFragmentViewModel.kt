package com.ds.pagoda.ui.fragments

import androidx.lifecycle.ViewModel
import com.ds.pagoda.data.repositories.CurrentWeatherRepository

class CurrentWeatherFragmentViewModel: ViewModel() {

    fun getCurrentWeather(){
        val currentWeatherResponce = CurrentWeatherRepository().getCurrentWeather()
    }
}