package com.example.composedemo

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class ResponseModel (
    @SerializedName("s.no") val sNo : Int,
    @SerializedName("amt.pledged") val amtPledged : Int,
    @SerializedName("blurb") val blurb : String,
    @SerializedName("by") val by : String,
    @SerializedName("country") val country : String,
    @SerializedName("currency") val currency : String,
    @SerializedName("end.time") val endTime : String,
    @SerializedName("location") val location : String,
    @SerializedName("percentage.funded") val percentageFunded : Int,
    @SerializedName("num.backers") val numBackers : String,
    @SerializedName("state") val state : String,
    @SerializedName("title") val title : String,
    @SerializedName("type") val type : String,
    @SerializedName("url") val url : String)