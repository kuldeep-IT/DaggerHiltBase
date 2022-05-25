package com.example.mvvmwithdi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import com.example.mvvmwithdi.model.Data
import com.example.mvvmwithdi.viewmodel.DataViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


//Processor : Application
//Battery : Activity
//Camera :  Fragment

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

     private val mViewModel: DataViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mViewModel.insertAllData(
            Data(1,"hbdfg","nfdgmdfgmnbdfg"),
            Data(2,"fnbghdfbg","nfdgmdfgmnbdfg"),
            Data(3,"hbdfgfmgbdfnbg","nfdgmdfgmnbdfg"),
            Data(4,"hbdfg","dfm,gnnfdgmdfgmnbdfg"),
            Data(5,"hbdfg","nfdgmdm,ndfgnfgmnbdfg"),
            Data(6,"hbdfg","nfdgmdfgmnbdfm,nfgg"),
            Data(7,"hbdfg","nfdgmdfgmnbdfgvm,nb"),
            Data(8,"hbdfg","nfdgmdfgmnbdfgzdfn dfbmn "),
        )

        mViewModel.dataLiveData.observe(this){
            Log.d("LOG_DATA", "onCreate: "+ it)
        }

    }


}