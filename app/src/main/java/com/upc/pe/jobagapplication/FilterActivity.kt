package com.upc.pe.jobagapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast

class FilterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_filter)

        val ivClaro = findViewById<ImageView>(R.id.iv_Claro)
        val ivMovistar = findViewById<ImageView>(R.id.iv_Movistar)

        ivClaro.setOnClickListener {
            val intent = Intent(this, EmpleoActivity1::class.java)
            startActivity(intent)
        }
        ivMovistar.setOnClickListener {
            val intent = Intent(this, EmpleoActivity2::class.java)
            startActivity(intent)
        }
    }
}