package com.example.mvvmwithdi.model

import android.util.Log
import javax.inject.Inject
import javax.inject.Named
import javax.inject.Singleton

@Singleton // for making single instance
class SnapDragon @Inject constructor(
    @Named("Core")
    var core: Int,

    @Named("ClockSpeed")
    var clockSpeed: Int
) : Processor {

    init {
        Log.d("LOG_SNAP_INIT", "init Snapdragon "  + this + " Core: "+ core +" clockSpeed: "+clockSpeed )
        start()
    }

    override fun start() {
        Log.d("LOG_SNAPDRAGON", "start: ")
    }
}