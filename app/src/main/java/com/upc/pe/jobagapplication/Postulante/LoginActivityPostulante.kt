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

            if (name.isNotBlank() && password.isNotBlank()) {
                PostulantService.postulantInstance.getPostulant(2)
                val id =  sharedPreferences.getValues("id")
                if(!id.isNullOrBlank()){
                    validatePostulant()
                }
            }
        }

        btRegister.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
    }
    private fun validatePostulant() {
        val sharedPreferences = SharedPreferences(this@LoginActivityPostulante)
        val id =  sharedPreferences.getValues("id").toString().toLong()
        val requestPost = PostulantService.postulantInstance.getPostulant(id)
        requestPost.enqueue(object : Callback<postulants> {
            override fun onFailure(call: Call<postulants>, t: Throwable) {
                Toast.makeText(this@LoginActivityPostulante, "No se pudo conectar, Intente de nuevo porfavor", Toast.LENGTH_LONG).show()
            }
            override fun onResponse(call: Call<postulants>, response: Response<postulants>) {
                if(response.isSuccessful){
                    val intent = Intent(this@LoginActivityPostulante, HomeActivity::class.java)
                    startActivity(intent)
                }

            }
        })
    }
}