package com.pedroimai.pets

import android.app.Application
import com.pedroimai.pets.frameworks.fuelSetup
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class PetsApplication : Application(){
    override fun onCreate() {
        super.onCreate()
        fuelSetup()
    }
}
