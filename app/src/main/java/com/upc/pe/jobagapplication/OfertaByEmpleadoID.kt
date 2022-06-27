package com.upc.pe.jobagapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.upc.pe.jobagapplication.Adapter.JobOfferAndEmpleadoIdAdapter
import com.upc.pe.jobagapplication.Adapter.JobOfferAnunciosEmpleadorAdapter
import com.upc.pe.jobagapplication.Model.JobOffer
import com.upc.pe.jobagapplication.Service.JobOfferService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class OfertaByEmpleadoID : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_oferta_by_empleado_id)

        val jobOfferId = getIntent().getIntExtra("jobOfferId", 0);

        Probando(jobOfferId)
    }

    private fun Probando(jobOfferId: Int) {
        lateinit var jobOffer: JobOffer
        lateinit var jobOfferAdapter: JobOfferAndEmpleadoIdAdapter

        val tvOfertaLaboralJobOffer = findViewById<TextView>(R.id.tvOfertaLaboralJobOffer)
        val tvDescripcionJobOffer = findViewById<TextView>(R.id.tvDescripcionJobOffer)
        val tvFechaPublicacionJobOffer = findViewById<TextView>(R.id.tvFechaPublicacionJobOffer)
        val tvFechaFinalJobOffer = findViewById<TextView>(R.id.tvFechaFinalJobOffer)
        val tvSalarioJobOffer = findViewById<TextView>(R.id.tvSalarioJobOffer)
        val tvDireccionJobOffer = findViewById<TextView>(R.id.tvDireccionJobOffer)

        val retrofit = Retrofit.Builder()
            .baseUrl("https://jobagbackend.herokuapp.com/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service: JobOfferService = retrofit.create(JobOfferService::class.java)

        val request = service.JobOfferIdAndEmpleadorId(jobOfferId, 1)

        request.enqueue(object : Callback<JobOffer>{
            override fun onResponse(call: Call<JobOffer>, response: Response<JobOffer>) {
                jobOffer = response.body()!!

                tvOfertaLaboralJobOffer.text = jobOffer.title
                tvDescripcionJobOffer.text = jobOffer.description
                tvFechaPublicacionJobOffer.text = jobOffer.begin_date_offer
                tvFechaFinalJobOffer.text = jobOffer.final_date_offer
                tvSalarioJobOffer.text = jobOffer.salary.toString()
                tvDireccionJobOffer.text = jobOffer.direction
            }

            override fun onFailure(call: Call<JobOffer>, t: Throwable) {
                Toast.makeText(this@OfertaByEmpleadoID, "No se pudo conectar, Intente de nuevo porfavor", Toast.LENGTH_LONG).show()
            }
        })
    }
}