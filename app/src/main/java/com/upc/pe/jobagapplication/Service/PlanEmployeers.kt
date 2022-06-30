package com.upc.pe.jobagapplication.Service

import com.upc.pe.jobagapplication.Model.JobOffer
import com.upc.pe.jobagapplication.Model.planemployeers
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface PlanEmployeers {
    @GET("employeers/{employeerId}/planemployeers/{planEmployeersId}")
    fun SuscriptionByIdAndEmployeerId(@Path("employeerId") employeerId: Int, @Path("planEmployeersId") planEmployeersId: Int): Call<planemployeers>

}