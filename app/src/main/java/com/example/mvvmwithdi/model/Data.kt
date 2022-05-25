package com.example.mvvmwithdi.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (tableName = "Data")
data class Data(
    @PrimaryKey(autoGenerate = true)
    var id: Long,
    var title: String,
    var desc: String

)
