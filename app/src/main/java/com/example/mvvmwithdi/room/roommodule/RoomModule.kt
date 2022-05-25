package com.example.mvvmwithdi.room.roommodule

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.mvvmwithdi.constants.Constants.DB_NAME
import com.example.mvvmwithdi.room.dao.DataDao
import com.example.mvvmwithdi.room.db.MyRoomDB
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

    @Provides
    @Singleton
    fun getDBName() :  String = DB_NAME

    @Provides
    @Singleton
    fun getRoomDB(@ApplicationContext context: Context, name: String) : MyRoomDB =
        Room.databaseBuilder(context,MyRoomDB::class.java, name).build()

    @Provides
    @Singleton
    fun getDataDao(db: MyRoomDB): DataDao = db.dataDao()

}