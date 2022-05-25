package com.example.mvvmwithdi.room.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.mvvmwithdi.model.Data

@Dao
interface DataDao {

    @Insert
    suspend fun insertData(data: Data)

    @Update
    suspend fun updateData(data: Data)

    @Delete
    suspend fun deleteData(data: Data)

    @Query("Select * from Data")
    fun getAllData(): LiveData<List<Data>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllData(vararg data: Data)
}