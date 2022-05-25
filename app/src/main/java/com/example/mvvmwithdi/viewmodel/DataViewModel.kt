package com.example.mvvmwithdi.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvmwithdi.model.Data
import com.example.mvvmwithdi.repository.DataRepository
import com.example.mvvmwithdi.ui.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class DataViewModel @Inject constructor(
    val repository: DataRepository
) : ViewModel() {

    private val _data: MutableLiveData<Resource<List<Data>>> = MutableLiveData()
    private val data: LiveData<Resource<List<Data>>> = _data

    fun getData() = viewModelScope.launch {
         val responseData = repository.getData()
         _data.postValue(handleData(responseData))
    }

    fun getLiveData() :  LiveData<Resource<List<Data>>> = data

    //decide success or error state
    private fun handleData(response: Response<List<Data>>) : Resource<List<Data>>
    {
        if (response.isSuccessful)
        {
            response.body()?.let { resultResponse ->

                return Resource.Success(resultResponse)

            }
        }
        return Resource.Error(response.message())
    }


}