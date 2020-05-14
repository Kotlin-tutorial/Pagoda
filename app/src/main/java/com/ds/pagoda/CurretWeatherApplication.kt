package com.ds.pagoda

import android.app.Application
import com.ds.pagoda.data.db.DataBase
import com.ds.pagoda.data.network.CurrentWeatherAPI
import com.ds.pagoda.data.repositories.CurrentWeatherRepository
import com.ds.pagoda.ui.fragments.CurrentWeatherFragmentViewModelFactory
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.androidCoreModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

class CurretWeatherApplication : Application(), KodeinAware {

    override val kodein: Kodein = Kodein.lazy {
        import(androidCoreModule(this@CurretWeatherApplication))

        bind() from singleton { CurrentWeatherAPI() }
        bind() from singleton { DataBase(instance()) }
        bind() from singleton { CurrentWeatherRepository(instance(),instance()) }
        bind() from provider { CurrentWeatherFragmentViewModelFactory(instance()) }

    }

}