package com.ds.pagoda.ui.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.ds.pagoda.R
import com.ds.pagoda.databinding.FragmentCurrentWeatherBinding
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.generic.instance
import org.kodein.di.android.x.kodein
import org.kodein.di.generic.kcontext

/**
 * A simple [Fragment] subclass.
 */
class CurrentWeatherFragment : Fragment(), KodeinAware {

    final override val kodeinContext = kcontext<Fragment>(this)
    final override val kodein: Kodein by kodein()

    private val factory : CurrentWeatherFragmentViewModelFactory by instance()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var binding: FragmentCurrentWeatherBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_current_weather,container,false)
        val viewModel = ViewModelProviders.of(this,factory).get(CurrentWeatherFragmentViewModel::class.java)

        binding.viewmodel = viewModel

        viewModel.getCurrentWeatherFromAPIandSaveToDB()

        viewModel.getCurrentWeather().observe(viewLifecycleOwner, Observer {
            currentWeather ->

            if(currentWeather != null) {
                Log.e("list_responce","symbol " + (currentWeather.name ?: "N/A"))

            }
        })

        return binding.root
    }

}
