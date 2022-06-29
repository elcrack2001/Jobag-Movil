package com.upc.pe.jobagapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.upc.pe.jobagapplication.Adapter.JobOfferAnunciosEmpleadorAdapter
import com.upc.pe.jobagapplication.Adapter.OnItemClickListener
import com.upc.pe.jobagapplication.Model.JobOffer
import com.upc.pe.jobagapplication.Service.JobOfferService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainEmpleadorActivity : AppCompatActivity(), OnItemClickListener {
    lateinit var jobOffers: List<JobOffer>
    lateinit var jobOfferAdapter: JobOfferAnunciosEmpleadorAdapter
    val EmpleadorId: Int = 4;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_empleador)

        LoadAnuncios()
    }

    private fun LoadAnuncios() {
        val rvMainEmpleadorAnuncios = findViewById<RecyclerView>(R.id.rvMainEmpleadorAnuncios)

        //URL del API
        val retrofit = Retrofit.Builder()
            .baseUrl("https://jobagbackend.herokuapp.com/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service: JobOfferService = retrofit.create(JobOfferService::class.java)

        val request = service.AllJobOffer(EmpleadorId);

        request.enqueue(object : Callback<List<JobOffer>> {
            override fun onResponse(call: Call<List<JobOffer>>, response: Response<List<JobOffer>>) {
                jobOffers = response.body()!!
                jobOfferAdapter = JobOfferAnunciosEmpleadorAdapter(jobOffers, this@MainEmpleadorActivity, EmpleadorId)
                Log.d("url", jobOffers.toString())
                rvMainEmpleadorAnuncios.adapter = jobOfferAdapter
                rvMainEmpleadorAnuncios.layoutManager = LinearLayoutManager(this@MainEmpleadorActivity)
            }

            override fun onFailure(call: Call<List<JobOffer>>, t: Throwable) {
                Toast.makeText(this@MainEmpleadorActivity, "No se pudo conectar, Intente de nuevo porfavor", Toast.LENGTH_LONG).show()
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        getMenuInflater().inflate(R.menu.menu_empleador, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.getItemId()

        if (id == R.id.Entrevistas_Empleador_Pendientes){
            val intent = Intent(this, EntrevistasPendientesEmpleadorActivity::class.java)
            intent.putExtra("EmpleadorId", EmpleadorId)
            startActivity(intent)
        }

        if (id == R.id.Inicio_Empleador){
            val intent = Intent(this, MainEmpleadorActivity::class.java)
            startActivity(intent)
        }

        if (id == R.id.Cerrar_Sesion){
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            Toast.makeText(this, "Se cerro la sesion correctamente", Toast.LENGTH_LONG).show()
        }

        if (id == R.id.Perfil_Empleador){
            val intent = Intent(this, PerfilEmpleadorActivity::class.java)
            //Pasar el id del empleador al activity
            intent.putExtra("EmpleadorId", EmpleadorId)
            startActivity(intent)
        }

        return super.onOptionsItemSelected(item)
    }

    override fun OnItemClick(position: Int) {
        val clickedItem = jobOffers[position]
        val jobOfferId = position + 1
        jobOfferAdapter.notifyItemChanged(position)

        val intent = Intent(this, OfertaByEmpleadoID::class.java)
        intent.putExtra("jobOfferId", jobOfferId)
        intent.putExtra("EmpleadorId", EmpleadorId)
        startActivity(intent)

    }
}