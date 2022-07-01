package com.upc.pe.jobagapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.upc.pe.jobagapplication.Postulante.LoginActivityPostulante

class EmpleoActivity1 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_empleo1)

        val btPostular = findViewById<Button>(R.id.bt_Claro_Postular)

        btPostular.setOnClickListener {
            val intent = Intent(this, PostulateActivity1::class.java)
            startActivity(intent)

        }


    }
}