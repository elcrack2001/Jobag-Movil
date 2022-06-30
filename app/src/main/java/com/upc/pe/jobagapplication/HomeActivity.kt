package com.upc.pe.jobagapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.upc.pe.jobagapplication.Empleador.LoginActivityEmpleador

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val btBusqueda=findViewById<Button>(R.id.bt_BuscarEmpleo)

        btBusqueda.setOnClickListener {
            val intent =Intent(this, FilterActivity::class.java)
            startActivity(intent)
        }


    }
}