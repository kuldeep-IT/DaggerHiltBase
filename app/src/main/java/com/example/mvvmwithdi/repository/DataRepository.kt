package com.example.mvvmwithdi.repository

import com.example.mvvmwithdi.model.Data
import com.example.mvvmwithdi.room.dao.DataDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class DataRepository @Inject constructor (val dataDao: DataDao) {

    suspend fun insertAll(vararg data: Data) = withContext(Dispatchers.IO){
        dataDao.insertAllData(*data)
    }

    fun getAllData() = dataDao.getAllData()

}