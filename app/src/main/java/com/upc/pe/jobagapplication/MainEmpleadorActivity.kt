package com.upc.pe.jobagapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem

class MainEmpleadorActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_empleador)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        getMenuInflater().inflate(R.menu.menu_empleador, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.getItemId()

        if (id == R.id.Entrevistas_Empleador_Pendientes){
            val intent = Intent(this, EntrevistasPendientesEmpleadorActivity::class.java)
            startActivity(intent)
        }

        if (id == R.id.Inicio_Empleador){
            val intent = Intent(this, MainEmpleadorActivity::class.java)
            startActivity(intent)
        }

        return super.onOptionsItemSelected(item)
    }
}