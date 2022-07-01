package com.upc.pe.jobagapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import java.util.HashMap


class PostulateActivity1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_postulate1)

        val uploadImageView = findViewById<Button>(R.id.btnSelecccionarArchivo)
        uploadImageView.setOnClickListener {
            val intent = Intent(this, PostulateActivity2::class.java)
            startActivity(intent)
        }
    }

}