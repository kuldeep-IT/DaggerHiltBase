package com.example.mvvmwithdi.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvmwithdi.repository.DataRepository
import com.example.mvvmwithdi.ui.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import okhttp3.ResponseBody
import retrofit2.Response
import java.util.HashMap
import javax.inject.Inject

@HiltViewModel
class DataViewModel @Inject constructor(
    val repository: DataRepository
) : ViewModel() {

    private val _data: MutableLiveData<Resource<Response<ResponseBody>>> = MutableLiveData()
    private val data: LiveData<Resource<Response<ResponseBody>>> = _data

    fun getData(endpoint: String) = viewModelScope.launch {
         val responseData = repository.getData(endpoint)
         _data.postValue(handleData(responseData, endpoint))
    }

    fun getLiveData() :  LiveData<Resource<Response<ResponseBody>>> = data

    //decide success or error state
    private fun handleData(response: Response<ResponseBody>, endpoint: String) : Resource<Response<ResponseBody>> {

        if (response.isSuccessful) {
            response?.let { resultResponse ->
                return Resource.Success(resultResponse, endpoint = endpoint)
            }
        }

        return Resource.Error(message = response.message())
//        return Resource.Error(JSONObject(body).getString("message"))
    }


    fun postDataApi(endpoint: String, body : Any) = viewModelScope.launch {
        //TODO: Get token from datastore
        var headers = HashMap<String, String>()
        headers["Content-Type"] = "application/json"
        headers["Authorization"] = "Bearer dbnjkansfklasfn2554121343"
        val responseData = repository.postApiData(endpoint , headers , body)
        _data.postValue(handleData(responseData, endpoint))
    }


}