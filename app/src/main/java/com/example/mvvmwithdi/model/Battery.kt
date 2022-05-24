package com.example.mvvmwithdi.model

import android.util.Log
import javax.inject.Inject

class Battery(
    var lithium: Lithium,
    var cobalt: Cobalt
) {
    // By default class in which we can't do changes
    // auto generated
    // eg. Retrofit instance ... Gson Builder

    init {
        Log.d("LOG_BATTERY", "Battery ")
    }
}