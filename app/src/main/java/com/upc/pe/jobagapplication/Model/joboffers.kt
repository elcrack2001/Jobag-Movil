package com.upc.pe.jobagapplication.Model

import com.google.gson.annotations.SerializedName
import java.time.LocalDate

data class joboffers (
    @SerializedName("idJobOffer")
    val id: Int,

    @SerializedName("employeer")
    val employeers: List<employeers>,

    @SerializedName("descriptionJobOffer")
    val description: String,

    @SerializedName("begin_date_offerJobOffer")
    val begin_date_offer: LocalDate,

    @SerializedName("final_date_offerJobOffer")
    val final_date_offer: LocalDate,

    @SerializedName("salaryJobOffer")
    val salary: Int,

    @SerializedName("typeJobOffer")
    val type: String,

    @SerializedName("titleJobOffer")
    val title: String,

    @SerializedName("directionJobOffer")
    val direction: String

        )