package com.upc.pe.jobagapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import android.widget.Toast
import com.upc.pe.jobagapplication.Model.employeers
import com.upc.pe.jobagapplication.Service.EmployeerInterface
import com.upc.pe.jobagapplication.Service.EmployeerService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class PerfilEmpleadorActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_perfil_empleador)

        val EmpleadorId = getIntent().getIntExtra("EmpleadorId", 0);
        val jobOfferId = getIntent().getIntExtra("jobOfferId", 0);

        EmployeerById(EmpleadorId)
    }

    private fun EmployeerById(empleadorId: Int) {
        lateinit var employeers: employeers

        val tvNombreEmpleadorPerfil = findViewById<TextView>(R.id.tvNombreEmpleadorPerfil)
        val tvApellidoEmpleadorPerfil = findViewById<TextView>(R.id.tvApellidoEmpleadorPerfil)
        val tvEmailEmpleadorPerfil = findViewById<TextView>(R.id.tvEmailEmpleadorPerfil)
        val tvTelefonoEmpleadorPerfil = findViewById<TextView>(R.id.tvTelefonoEmpleadorPerfil)
        val tvDocumentoEmpleadorPerfil = findViewById<TextView>(R.id.tvDocumentoEmpleadorPerfil)
        val tvPosicionEmpleadorPerfil = findViewById<TextView>(R.id.tvPosicionEmpleadorPerfil)

        val retrofit = Retrofit.Builder()
            .baseUrl("https://jobagbackend.herokuapp.com/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service: EmployeerInterface = retrofit.create(EmployeerInterface::class.java)

        val request = service.EmployeerById(empleadorId)

        request.enqueue(object : Callback<employeers> {
            override fun onResponse(call: Call<employeers>, response: Response<employeers>) {
                employeers = response.body()!!

                tvNombreEmpleadorPerfil.text = employeers.firstname
                tvApellidoEmpleadorPerfil.text = employeers.lastname
                tvEmailEmpleadorPerfil.text = employeers.email
                tvTelefonoEmpleadorPerfil.text = employeers.number.toString()
                tvDocumentoEmpleadorPerfil.text = employeers.document.toString()
                tvPosicionEmpleadorPerfil.text = employeers.posicion.toString()
            }

            override fun onFailure(call: Call<employeers>, t: Throwable) {
                Toast.makeText(this@PerfilEmpleadorActivity, "No se pudo conectar, Intente de nuevo porfavor", Toast.LENGTH_LONG).show()
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