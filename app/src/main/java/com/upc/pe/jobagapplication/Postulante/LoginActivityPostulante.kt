package com.upc.pe.jobagapplication.Postulante

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.jobag.Service.PostulantService
import com.upc.pe.jobagapplication.HomeActivity
import com.upc.pe.jobagapplication.Model.postulants
import com.upc.pe.jobagapplication.R
import com.upc.pe.jobagapplication.RegisterActivity
import com.upc.pe.jobagapplication.SharedPreferences
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivityPostulante : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val sharedPreferences = SharedPreferences(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_postulante)

        val etUser = findViewById<EditText>(R.id.et_email_p)
        val etPassword = findViewById<EditText>(R.id.et_password_p)
        val btLogin = findViewById<Button>(R.id.bt_Login_p)
        val btRegister = findViewById<Button>(R.id.bt_Register_p)

        btLogin.setOnClickListener {
            val name = etUser.text.toString()
            val password = etPassword.text.toString()

            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
            Toast.makeText(this@LoginActivityPostulante, "Inicio de sesión correcto", Toast.LENGTH_LONG).show()

        }

        btRegister.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
    }
}