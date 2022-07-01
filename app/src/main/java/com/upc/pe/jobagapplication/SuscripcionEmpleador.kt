package com.upc.pe.jobagapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import android.widget.Toast
import com.upc.pe.jobagapplication.Model.employeers
import com.upc.pe.jobagapplication.Model.planemployeers
import com.upc.pe.jobagapplication.R
import com.upc.pe.jobagapplication.Service.EmployeerInterface
import com.upc.pe.jobagapplication.Service.PlanEmployeers
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class SuscripcionEmpleador : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_suscripcion_empleador)

        Empleador(1)
        Suscripcion(1,1)
    }

    private fun Empleador(empleadorId: Int) {
        lateinit var employeers: employeers

        val tvNombreSuscripcion = findViewById<TextView>(R.id.tvNombreSuscripcion)
        val tvApellidoSuscripcion = findViewById<TextView>(R.id.tvApellidoSuscripcion)
        val tvEmailSuscripcion = findViewById<TextView>(R.id.tvEmailSuscripcion)

        val retrofit = Retrofit.Builder()
            .baseUrl("https://jobagbackend.herokuapp.com/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service: EmployeerInterface = retrofit.create(EmployeerInterface::class.java)

        val request = service.EmployeerById(empleadorId)

        request.enqueue(object : Callback<employeers> {
            override fun onResponse(call: Call<employeers>, response: Response<employeers>) {
                employeers = response.body()!!

                tvNombreSuscripcion.text = employeers.firstname
                tvApellidoSuscripcion.text = employeers.lastname
                tvEmailSuscripcion.text = employeers.email
            }

            override fun onFailure(call: Call<employeers>, t: Throwable) {
                Toast.makeText(this@SuscripcionEmpleador, "No se pudo conectar, Intente de nuevo porfavor", Toast.LENGTH_LONG).show()
            }
        })
    }

    private fun Suscripcion(empleadorId: Int, planEmployeerId: Int) {
        lateinit var planemployeers: planemployeers

        val tvSuscripcion = findViewById<TextView>(R.id.tvSuscripcion)
        val tvEstadoSuscripcion = findViewById<TextView>(R.id.tvEstadoSuscripcion)
        val tvFechaSuscripcion = findViewById<TextView>(R.id.tvFechaSuscripcion)

        val retrofit = Retrofit.Builder()
            .baseUrl("https://jobagbackend.herokuapp.com/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service: PlanEmployeers = retrofit.create(PlanEmployeers::class.java)

        val request = service.SuscriptionByIdAndEmployeerId(empleadorId,planEmployeerId)

        Log.d("url",
            service.SuscriptionByIdAndEmployeerId(empleadorId,planEmployeerId).request().toString()
        )

        request.enqueue(object : Callback<planemployeers> {
            override fun onResponse(call: Call<planemployeers>, response: Response<planemployeers>) {
                planemployeers = response.body()!!

                Log.d("url",planemployeers.toString())
                tvSuscripcion.text = planemployeers.description
                tvEstadoSuscripcion.text = planemployeers.asistence.toString()
                tvFechaSuscripcion.text = planemployeers.duration
            }

            override fun onFailure(call: Call<planemployeers>, t: Throwable) {
                Toast.makeText(this@SuscripcionEmpleador, "No se pudo conectar, Intente de nuevo porfavor", Toast.LENGTH_LONG).show()
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
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

        if (id == R.id.Suscripcion_Empleador){
            val intent = Intent(this, SuscripcionEmpleador::class.java)
            //Pasar el id del empleador al activity
            intent.putExtra("EmpleadorId", EmpleadorId)
            startActivity(intent)
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