package com.upc.pe.jobagapplication.Service

import com.upc.pe.jobagapplication.Model.Interview
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface InterviewService {

    @GET("interviews/")
    fun AllInterview(@Query("id") id: Int): Call<List<Interview>>
}