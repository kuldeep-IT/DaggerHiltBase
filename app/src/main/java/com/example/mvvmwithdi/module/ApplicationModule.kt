package com.example.mvvmwithdi.module

import android.util.Log
import com.example.mvvmwithdi.model.Processor
import com.example.mvvmwithdi.model.SnapDragon
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Named
import kotlin.math.log


//Standard manners for calling interface using abstract
//@Module
//@InstallIn(SingletonComponent::class)
//abstract class SnapDragonModule {
//
//    //i can take reference of class which is extend by it's interface
//    // Processor is reference of snapdragon class
//    // interface's implementation is called in constructor
//    @Binds
//    abstract fun getProcessor(snapDragon: SnapDragon): Processor
//
//
//}

  // Second Method
@Module
@InstallIn(SingletonComponent::class)
object ApplicationModule{

    @Provides
    fun getProcessor(snapDragon: SnapDragon) : Processor = snapDragon

//    @Provides
//    fun getSnapDragon() : SnapDragon = SnapDragon()

      @Provides
      @Named("Core")
      fun getCore() = 1

      @Named("ClockSpeed")
      @Provides
      fun getClockSpeed() = 2

}
