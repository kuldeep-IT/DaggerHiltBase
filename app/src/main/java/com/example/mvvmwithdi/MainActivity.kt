package com.example.mvvmwithdi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.ViewModel
import com.example.mvvmwithdi.ui.Resource
import com.example.mvvmwithdi.viewmodel.DataViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


//Processor : Application
//Battery : Activity
//Camera :  Fragment

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {


    private val dataViewModel: DataViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        dataViewModel.getLiveData().observe(this){response ->
            when(response){
                is Resource.Success -> {
//                    hideProgressBar()
                    response.data?.let { newsResponse ->
                        Log.d("API_RESPONSE", "${newsResponse} ")
                    }
                }
            }
        }

        dataViewModel.getData()

    }


}