package com.upc.pe.jobagapplication.Model

import com.google.gson.annotations.SerializedName

data class employeers (
    @SerializedName("id")
    val id : Int,

    @SerializedName("firstname")
    val firstname: String,

    @SerializedName("lastname")
    val lastname: String,

    @SerializedName("email")
    val email: String,

    @SerializedName("number")
    val number: Int,

    @SerializedName("password")
    val password: String,

    @SerializedName("document")
    val document: String,

    @SerializedName("posicion")
    val posicion: String
        )