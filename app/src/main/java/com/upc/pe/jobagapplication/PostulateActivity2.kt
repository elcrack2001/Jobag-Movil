package com.upc.pe.jobagapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class PostulateActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_postulate2)
        val btPresenta = findViewById<Button>(R.id.btPresentacion)
        btPresenta.setOnClickListener {
            val intent = Intent(this, PostulateActivity3::class.java)
            startActivity(intent)
        }
    }
}