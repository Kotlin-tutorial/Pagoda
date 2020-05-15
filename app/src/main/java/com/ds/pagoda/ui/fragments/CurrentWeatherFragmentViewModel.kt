package com.ds.pagoda.ui.fragments

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.ds.pagoda.data.db.entities.CurrentWeatherEntity
import com.ds.pagoda.data.network.responces.CurrentWeatherResponce
import com.ds.pagoda.data.repositories.CurrentWeatherRepository
import com.ds.pagoda.utils.Coroutines
import retrofit2.Response

class CurrentWeatherFragmentViewModel(

    private val currentWeatherRepository: CurrentWeatherRepository

): ViewModel() {

    fun getCurrentWeatherFromAPIandSaveToDB(){
        Coroutines.backGround{
            val currentWeatherResponce : Response<CurrentWeatherResponce> = currentWeatherRepository.getCurrentWeather()

            val currentWeatherEntity : CurrentWeatherEntity = CurrentWeatherEntity(
                currentWeatherResponce.body()?.id?.toInt(),
                currentWeatherResponce.body()?.main.toString(),
                currentWeatherResponce.body()?.weather?.get(0)?.description.toString(),
                currentWeatherResponce.body()?.main?.temp,
                currentWeatherResponce.body()?.wind?.speed,
                currentWeatherResponce.body()?.wind?.deg,
                currentWeatherResponce.body()?.sys?.sunset,
                currentWeatherResponce.body()?.name.toString(),
                currentWeatherResponce.body()?.dt
            )

            currentWeatherRepository.saveCurrentWeatherTODB(currentWeatherEntity)
        }
    }

     fun getCurrentWeather(): LiveData<CurrentWeatherEntity> {
        val currentWeathe: LiveData<CurrentWeatherEntity> = currentWeatherRepository.getCurrentWeatherFromDB()
        return currentWeathe
    }




}