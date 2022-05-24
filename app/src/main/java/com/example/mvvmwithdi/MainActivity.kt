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
    lateinit var processor1: Processor

    @Inject
    lateinit var processor2: Processor


    @Inject
    lateinit var battery1: Battery

    @Inject
    lateinit var battery2: Battery


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d("LOG_DAGGER", "MainActivity::::::::::::::::::::::::::::::  ")
        Log.d("LOG_DAGGER", "MAinApplication: $processor1")
        Log.d("LOG_DAGGER", "MAinApplication: $processor2")
        Log.d("LOG_DAGGER", "MAinApplication: $battery1")
        Log.d("LOG_DAGGER", "MAinApplication: $battery2")

        replace(MainFragment())

    }

    fun replace(fragment: Fragment)
    {
        val beginTransaction = supportFragmentManager.beginTransaction()
        beginTransaction.replace(R.id.flayout, fragment)
        beginTransaction.commit()
    }

}