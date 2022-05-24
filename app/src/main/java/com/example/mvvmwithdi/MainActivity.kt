package com.example.mvvmwithdi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import com.example.mvvmwithdi.model.Battery
import com.example.mvvmwithdi.model.Processor
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


//Processor : Application
//Battery : Activity
//Camera :  Fragment

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var mobile1: Mobile

    @Inject
    lateinit var mobile2: Mobile

    @Inject
    lateinit var battery1: Battery

    @Inject
    lateinit var battery2: Battery

    @Inject
    lateinit var processor1: Processor

    @Inject
    lateinit var processor2: Processor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        Log.d("LOG_MAIN", "onCreate: "+BatteryModule.getBattery(mobile.battery.lithium, mobile.battery.cobalt))
//        Log.d("LOG_MAIN", "onCreate: LITHIUM "+BatteryModule.getLithium().test())
//        Log.d("LOGD_MAIN", "onCreate: "+ mobile1 + " $mobile1")
//        Log.d("LOGD_MAIN", "onCreate: "+ mobile2 + " $mobile2")

        Log.d("LOG_DAGGER", "MainActivity:::::::::::::::::::::::::::::: ")
        Log.d("LOG_DAGGER", "MainActivity: processor1 $processor1")
        Log.d("LOG_DAGGER", "MainActivity: processor2 $processor2")
        Log.d("LOG_DAGGER", "MainActivity: battery1 $battery1")
        Log.d("LOG_DAGGER", "MainActivity: battery2 $battery2")

        replace(MainFragment())
    }

    fun replace(fragment: Fragment){
        val beginTransaction = supportFragmentManager.beginTransaction()
        beginTransaction.replace(R.id.flayout, fragment)
        beginTransaction.commit()
    }
}