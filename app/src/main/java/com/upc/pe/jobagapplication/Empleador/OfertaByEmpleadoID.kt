package com.upc.pe.jobagapplication.Empleador

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import android.widget.Toast
import com.upc.pe.jobagapplication.MainActivity
import com.upc.pe.jobagapplication.Model.JobOffer
import com.upc.pe.jobagapplication.R
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

        val EmpleadorId = getIntent().getIntExtra("EmpleadorId", 0);
        val jobOfferId = getIntent().getIntExtra("jobOfferId", 0);

        JobOfferByEmployeerId(jobOfferId, EmpleadorId)
    }

    private fun JobOfferByEmployeerId(jobOfferId: Int, EmpleadorId: Int) {
        lateinit var jobOffer: JobOffer

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

        val request = service.JobOfferIdAndEmpleadorId(jobOfferId, EmpleadorId)

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

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        getMenuInflater().inflate(R.menu.menu_empleador, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.getItemId()
        val EmpleadorId = getIntent().getIntExtra("EmpleadorId", 0);

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
}