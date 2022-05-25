package com.example.mvvmwithdi.api

import com.example.mvvmwithdi.model.Data
import retrofit2.Response
import retrofit2.http.GET

interface DataAPI {

    @GET("/posts")
    suspend fun getData() : Response<List<Data>>

}