package com.upc.pe.jobagapplication.Model

import com.google.gson.annotations.SerializedName
import java.time.LocalDate

class Interview (

    @SerializedName("id")
    val id : Int,

    @SerializedName("date_Interview")
    val date_Interview: String,

    @SerializedName("final_date_Interview")
    val final_date_Interview: String,

    @SerializedName("link_Interview")
    val link_Interview: String
)