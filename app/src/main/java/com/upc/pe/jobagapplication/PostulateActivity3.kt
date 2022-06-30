package com.upc.pe.jobagapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class PostulateActivity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_postulate3)
        val cbAcepto = findViewById<Button>(R.id.cbAcepto)
        cbAcepto.setOnClickListener {
            val intent = Intent(this, PostulateActivity4::class.java)
            startActivity(intent)
        }
    }
}