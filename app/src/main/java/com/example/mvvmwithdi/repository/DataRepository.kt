package com.example.mvvmwithdi.repository

import com.example.mvvmwithdi.api.DataAPI
import javax.inject.Inject

class DataRepository @Inject constructor(val dataAPI: DataAPI) {

    suspend fun getData() = dataAPI.getData()

}