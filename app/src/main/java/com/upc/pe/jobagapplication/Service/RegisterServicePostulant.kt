package com.example.jobag.Service

import com.example.paradox.models.RequestEmployeer
import com.example.paradox.models.RequestPostulant
import com.example.paradox.models.ResponseEmployeer
import com.example.paradox.models.ResponsePostulant
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.POST

const val BASE_URL3 = "https://jobagbackend.herokuapp.com/"

interface RegisterInterfacePostulant{
    @POST("/api/postulants")
    fun createEmployeer(@Body requestPostulant: RequestPostulant): Call<ResponsePostulant>
}
object RegisterPostulantService {
    val registerInstance: RegisterInterfacePostulant
    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL3)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        registerInstance = retrofit.create(RegisterInterfacePostulant::class.java)
    }
}