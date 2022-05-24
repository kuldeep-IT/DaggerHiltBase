package com.example.mvvmwithdi

import android.util.Log
import com.example.mvvmwithdi.model.Battery
import com.example.mvvmwithdi.model.Processor
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


class Mobile @Inject constructor
    (
    var battery: Battery,
    var prqocessor: Processor
) {
    init {
        Log.d("LOGD_MOBILE", "MOBILE $this battery $battery processor $prqocessor")
    }
}