package com.example.mvvmwithdi.api

import com.example.mvvmwithdi.model.Data
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.*
import java.util.HashMap

interface DataAPI {

    @GET
    suspend fun getData(@Url endpoint: String): Response<ResponseBody>

    @POST
    suspend fun postApiData(@Url endPoint: String, @HeaderMap hashMap: HashMap<String, String>, @Body requestClass: Any): Response<ResponseBody>



//    @GET("/posts")
//    suspend fun getData() : Response<ResponseBody>

}