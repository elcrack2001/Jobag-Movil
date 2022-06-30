package com.upc.pe.jobagapplication.Model

import com.google.gson.annotations.SerializedName
import java.time.LocalDate

data class planemployeers  (
    @SerializedName("id")
    val id: Int,

    @SerializedName("description")
    val description: String,

    @SerializedName("limit_videoconference")
    val limit_videoconference: Int,

    @SerializedName("limit_modification")
    val limit_modification: Int,

    @SerializedName("asistence")
    val asistence: Boolean,

    @SerializedName("duration")
    val duration: String
)