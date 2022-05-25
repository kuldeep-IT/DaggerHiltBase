package com.example.mvvmwithdi.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvmwithdi.model.Data
import com.example.mvvmwithdi.repository.DataRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DataViewModel @Inject constructor (val dataRepository: DataRepository): ViewModel() {

    val dataLiveData = dataRepository.getAllData()

    fun insertAllData(vararg data: Data) = viewModelScope.launch {

        dataRepository.insertAll(*data)

    }


}