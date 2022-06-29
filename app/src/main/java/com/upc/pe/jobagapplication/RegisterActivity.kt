package com.upc.pe.jobagapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.upc.pe.jobagapplication.Empleador.RegisterActivityEmpleador
import com.upc.pe.jobagapplication.Postulante.RegisterActivityPostulante

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val btnRegisterEmpleador = findViewById<Button>(R.id.bt_Empleador)
        val btnRegisterPostulant=findViewById<Button>(R.id.bt_Postulant)

        btnRegisterEmpleador.setOnClickListener {
            val intent = Intent(this, RegisterActivityEmpleador::class.java)
            startActivity(intent)
        }
        btnRegisterPostulant.setOnClickListener {
            val intent = Intent(this, RegisterActivityPostulante::class.java)
            startActivity(intent)
        }

    }
}