package com.example.jobag.Service

import com.upc.pe.jobagapplication.Model.employeers
import com.upc.pe.jobagapplication.Model.postulants
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

const val BASE_URL2 = "https://jobagbackend.herokuapp.com/"
interface PostulantInterface {

    //Get
    @GET("/api/postulants/{id}")
    fun getPostulant(@Path("id") email: Long): Call<postulants>
}

object PostulantService {
    val postulantInstance: PostulantInterface
    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL2)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        postulantInstance = retrofit.create(PostulantInterface::class.java)
    }
}

