package com.upc.pe.jobagapplication.Service

import com.upc.pe.jobagapplication.Model.JobOffer
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface JobOfferService {
    @GET("jobOffers/")
    fun AllJobOffer(@Query("id") id: Int): Call<List<JobOffer>>

    @GET("jobOffers/{jobOfferId}/employeers/{employeerId}")
    fun JobOfferIdAndEmpleadorId(@Path("jobOfferId") jobOfferId: Int, @Path("employeerId") employeerId: Int): Call<JobOffer>
}