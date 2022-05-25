package com.example.mvvmwithdi.model

import android.icu.text.CaseMap
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
class User {

    val userId : Int = 0
    var id : Int = 0
    var title : String = ""
    var body : String = ""
    @JsonProperty("location")
    var locationName : String = ""
}