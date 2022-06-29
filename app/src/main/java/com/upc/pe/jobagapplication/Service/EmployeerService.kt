package com.upc.pe.jobagapplication.Service

import com.upc.pe.jobagapplication.Model.employeers
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface EmployeerService {
    @GET("employeers/{employeerId}")
    fun EmployeerById(@Path("employeerId") employeerId: Int): Call<employeers>
}