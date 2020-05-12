package com.ds.pagoda.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.view.WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS
import android.view.WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS
import androidx.core.content.ContextCompat
import com.ds.pagoda.R
import com.ds.pagoda.ui.fragments.CurrentWeatherFragment

class MainActivity : AppCompatActivity() {

    private val fragmentManager = supportFragmentManager
    private val currentWeatherFragment = CurrentWeatherFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /* Changin the action bar color to mach the full background */
        val window: Window = this.window
        window.clearFlags(FLAG_TRANSLUCENT_STATUS)
        window.addFlags(FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        window.statusBarColor = ContextCompat.getColor(applicationContext, R.color.statusBarColor)


        /* Display Current Weather Fragment  */
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragment_continer, currentWeatherFragment)
        fragmentTransaction.commit()
    }
}
