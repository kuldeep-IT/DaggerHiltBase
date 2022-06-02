package com.example.mvvmwithdi.model

import android.icu.text.CaseMap
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
class User {

    var userId : Int = 0
    var id : Int = 0
    var title : String = ""
    var body : String = ""
    @JsonProperty("location")
    var locationName : String = ""

    constructor(userId: Int, id:Int, title: String, body: String, locationName: String){
        this.userId = userId
        this.id  = id
        this.title = title
        this.body = body
        this.locationName = locationName
    }
}