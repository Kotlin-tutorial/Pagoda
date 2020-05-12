package com.ds.pagoda.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders

import com.ds.pagoda.R
import com.ds.pagoda.databinding.FragmentCurrentWeatherBinding

/**
 * A simple [Fragment] subclass.
 */
class CurrentWeatherFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var binding: FragmentCurrentWeatherBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_current_weather,container,false)
        val viewModel = ViewModelProviders.of(this).get(CurrentWeatherFragmentViewModel::class.java)

        binding.viewmodel = viewModel

        viewModel.getCurrentWeather()

        return binding.root
    }

}
