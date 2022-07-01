package com.upc.pe.jobagapplication.Postulante

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.upc.pe.jobagapplication.HomeActivity
import com.upc.pe.jobagapplication.R

class RegisterActivityPostulante : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_postulante)

        val bt_Register_Postulante= findViewById<Button>(R.id.bt_Register_P)

        bt_Register_Postulante.setOnClickListener {

            val intent = Intent(this, LoginActivityPostulante::class.java)
            startActivity(intent)
            Toast.makeText(this@RegisterActivityPostulante, "Se registró correctamente", Toast.LENGTH_LONG).show()

        }


    }
}