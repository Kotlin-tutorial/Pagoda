package com.ds.pagoda.ui.fragments

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.ds.pagoda.data.repositories.CurrentWeatherRepository

@Suppress("UNCHECKED_CAST")
class CurrentWeatherFragmentViewModelFactory(
    private val repository: CurrentWeatherRepository
) : ViewModelProvider.NewInstanceFactory()
{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return CurrentWeatherFragmentViewModel(repository) as T
    }
}