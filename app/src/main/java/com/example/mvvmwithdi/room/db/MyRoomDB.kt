package com.example.mvvmwithdi.room.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.mvvmwithdi.model.Data
import com.example.mvvmwithdi.room.dao.DataDao

@Database(
    entities = [Data::class],
    version = 1,
    exportSchema = false
    )
abstract class MyRoomDB : RoomDatabase() {

    abstract fun dataDao(): DataDao

}