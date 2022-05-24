package com.example.mvvmwithdi

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mvvmwithdi.model.Battery
import com.example.mvvmwithdi.model.Camera
import com.example.mvvmwithdi.model.Processor
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainFragment : Fragment() {

    private lateinit var mView: View

    @Inject
    lateinit var camera1: Camera

    @Inject
    lateinit var camera2: Camera


    @Inject
    lateinit var battery1: Battery

    @Inject
    lateinit var battery2: Battery

    @Inject
    lateinit var processor1: Processor

    @Inject
    lateinit var processor2: Processor

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        mView = inflater.inflate(R.layout.fragment_main, container, false)

        Log.d("LOG_DAGGER", "MainFragment:::::::::::::::::::::::::::::: ")
        Log.d("LOG_DAGGER", "MainFragment: processor1 $processor1")
        Log.d("LOG_DAGGER", "MainFragment: processor2 $processor2")
        Log.d("LOG_DAGGER", "MainFragment: battery1 $battery1")
        Log.d("LOG_DAGGER", "MainFragment: battery2 $battery2")
        Log.d("LOG_DAGGER", "MainFragment: camera1 $camera1")
        Log.d("LOG_DAGGER", "MainFragment: camera2 $camera2")

        return mView
    }



}