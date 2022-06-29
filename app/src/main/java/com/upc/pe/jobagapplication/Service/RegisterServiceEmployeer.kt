package com.example.jobag.Service

import com.example.paradox.models.RequestEmployeer
import com.example.paradox.models.ResponseEmployeer
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.POST

const val BASE_URL4 = "https://jobagbackend.herokuapp.com/"

interface RegisterInterface{
    @POST("/api/employeers")
    fun createEmployeer(@Body requestEmployeer: RequestEmployeer): Call<ResponseEmployeer>
}

object RegisterEmployeerService {
    val registerInstance: RegisterInterface
    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL4)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        registerInstance = retrofit.create(RegisterInterface::class.java)
    }
}