package com.example.mvvmwithdi

import android.app.Application
import android.util.Log
import com.example.mvvmwithdi.model.Processor
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

@HiltAndroidApp
class MainApplication : Application(){

    @Inject
    lateinit var processor1: Processor

    @Inject
    lateinit var processor2: Processor



    override fun onCreate() {
        super.onCreate()

        Log.d("LOG_DAGGER", "MainApplication:::::::::::::::::::::::::::::: ")
        Log.d("LOG_DAGGER", "MAinApplication: processor1 $processor1")
        Log.d("LOG_DAGGER", "MAinApplication: processor2 $processor2")

    }

}