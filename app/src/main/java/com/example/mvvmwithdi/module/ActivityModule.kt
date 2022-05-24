package com.example.mvvmwithdi.module

import android.util.Log
import com.example.mvvmwithdi.model.Battery
import com.example.mvvmwithdi.model.Cobalt
import com.example.mvvmwithdi.model.Lithium
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.scopes.ActivityScoped
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

//Module -> By default or auto generated class's access is done through module

@Module
@InstallIn(ActivityComponent::class)
object ActivityModule {

    init {
        Log.d("LOG_BATTERY_MODULE", "B MODULE ")
    }

    @Provides
    fun getLithium(): Lithium{
        val lithium = Lithium()
        lithium.test()
        return lithium
    }

    @Provides
    fun getCobalt(): Cobalt{
        return Cobalt()
    }

    @ActivityScoped
    @Provides
    fun getBattery(
        lithium: Lithium,
        cobalt: Cobalt
    ): Battery {
        return Battery(lithium, cobalt)
    }

}