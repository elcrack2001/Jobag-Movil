package com.upc.pe.jobagapplication.Model

import com.google.gson.annotations.SerializedName

data class employeers (
    @SerializedName("idEmployeer")
    val id : Int,

    @SerializedName("firstnameEmployeer")
    val firstname: String,

    @SerializedName("lastnameEmployeer")
    val lastname: String,

    @SerializedName("emailEmployeer")
    val email: String,

    @SerializedName("numberEmployeer")
    val number: Int,

    @SerializedName("passwordEmployeer")
    val password: String,

    @SerializedName("documentEmployeer")
    val document: String,

    @SerializedName("posicionEmployeer")
    val posicion: String
        )