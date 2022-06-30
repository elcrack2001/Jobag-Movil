package com.upc.pe.jobagapplication.Empleador

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.upc.pe.jobagapplication.Postulante.LoginActivityPostulante
import com.upc.pe.jobagapplication.R

class RegisterActivityEmpleador : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_empleador)
        val bt_Register_Postulante= findViewById<Button>(R.id.bt_Register_E)

        bt_Register_Postulante.setOnClickListener {

            val intent = Intent(this, LoginActivityEmpleador::class.java)
            startActivity(intent)
            Toast.makeText(this@RegisterActivityEmpleador, "Se registró correctamente", Toast.LENGTH_LONG).show()

        }
    }
}