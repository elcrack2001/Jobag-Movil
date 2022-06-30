package com.upc.pe.jobagapplication.Service

import com.upc.pe.jobagapplication.Model.JobOffer
import com.upc.pe.jobagapplication.Model.employeers
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*


const val BASE_URL1 = "https://jobagbackend.herokuapp.com/"
interface EmployeerInterface {
    @GET("employeers/{employeerId}")
    fun EmployeerById(@Path("employeerId") employeerId: Int): Call<employeers>

    //Get
    @GET("api/employeers/{id}")
    fun getEmployeer(@Path("id") email: Long): Call<employeers>

    @FormUrlEncoded
    @POST("employeers/{employeerId}/joboffers")
    fun createJobOffer(
        @Field("employeerId") userId: Int
    ): Call<JobOffer>?
}

object EmployeerService {
    val employeerInstance: EmployeerInterface
    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL1)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        employeerInstance = retrofit.create(EmployeerInterface::class.java)
    }
}