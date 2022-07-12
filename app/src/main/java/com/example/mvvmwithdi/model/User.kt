package com.example.mvvmwithdi.model

import android.icu.text.CaseMap
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
class User {

    @JsonProperty("userId")
    var userId : Int = 0
    @JsonProperty("id")
    var id : Int = 0
    @JsonProperty("title")
    var title : String = ""
    @JsonProperty("body")
    var body : String = ""
    /*@JsonProperty("location")
    var locationName : String = ""*/


    constructor()

    constructor(userId: Int, id:Int, title: String, body: String/*, locationName: String*/){
        this.userId = userId
        this.id  = id
        this.title = title
        this.body = body
    /*    this.locationName = locationName*/
    }
}