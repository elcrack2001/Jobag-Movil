package com.upc.pe.jobagapplication.Model

import com.google.gson.annotations.SerializedName

data class postulants (
    @SerializedName("idPostulant")
    val id: Int,

    @SerializedName("firstnamePostulant")
    val firstname: String,

    @SerializedName("lastnamePostulant")
    val lastname: String,

    @SerializedName("emailPostulant")
    val email: String,

    @SerializedName("numberPostulant")
    val number: Int,

    @SerializedName("passwordPostulant")
    val password: String,

    @SerializedName("documentPostulant")
    val document: String,

    @SerializedName("civilStatusPostulant")
    val civil_status: String

)