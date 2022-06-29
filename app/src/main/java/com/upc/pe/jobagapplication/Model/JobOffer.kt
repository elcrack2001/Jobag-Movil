package com.upc.pe.jobagapplication.Model

import com.google.gson.annotations.SerializedName

data class JobOffer (
    @SerializedName("id")
    val id: Int,

    val employeer: employeers,

    @SerializedName("type")
    val type: String,

    @SerializedName("title")
    val title: String,

    @SerializedName("description")
    val description: String,

    @SerializedName("begin_date_offer")
    val begin_date_offer: String,

    @SerializedName("final_date_offer")
    val final_date_offer: String,

    @SerializedName("salary")
    val salary: Int,

    @SerializedName("direction")
    val direction: String
    )