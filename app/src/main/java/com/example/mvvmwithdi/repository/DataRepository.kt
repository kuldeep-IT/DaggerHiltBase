package com.example.mvvmwithdi.repository

import com.example.mvvmwithdi.api.DataAPI
import retrofit2.http.HeaderMap
import java.util.HashMap
import javax.inject.Inject

class DataRepository @Inject constructor(val dataAPI: DataAPI) {

    suspend fun getData(endpoint : String) = dataAPI.getData(endpoint)
    suspend fun postApiData(endpoint : String , headers : HashMap<String, String>, body : Any) = dataAPI.postApiData(endpoint , headers , body)

}