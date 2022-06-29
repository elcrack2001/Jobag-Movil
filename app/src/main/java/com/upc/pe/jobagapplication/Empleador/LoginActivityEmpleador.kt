package com.upc.pe.jobagapplication.Empleador

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import com.upc.pe.jobagapplication.HomeActivity
import com.upc.pe.jobagapplication.Model.employeers
import com.upc.pe.jobagapplication.R
import com.upc.pe.jobagapplication.RegisterActivity
import com.upc.pe.jobagapplication.Service.EmployeerService
import com.upc.pe.jobagapplication.SharedPreferences
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivityEmpleador : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val sharedPreferences = SharedPreferences(this@LoginActivityEmpleador)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_empleador)

        val etUser = findViewById<EditText>(R.id.et_email_e)
        val etPassword = findViewById<EditText>(R.id.et_password_e)
        val btLogin = findViewById<Button>(R.id.bt_Login_e)
        val btRegister = findViewById<Button>(R.id.bt_Register_e)

        btLogin.setOnClickListener {

            val name = etUser.text.toString()
            val password = etPassword.text.toString()
            if (name.isNotBlank() && password.isNotBlank()) {
                val id =  sharedPreferences.getValues("id")
                if(!id.isNullOrBlank()){
                    validateEmployeer()
                }
            }
        }

        btRegister.setOnClickListener {

            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
    }
    private fun validateEmployeer() {
        val sharedPreferences = SharedPreferences(this@LoginActivityEmpleador)


        val id =  sharedPreferences.getValues("id").toString().toLong()
        val requestPost = EmployeerService.employeerInstance.getEmployeer(id)
        requestPost.enqueue(object : Callback<employeers> {
            override fun onFailure(call: Call<employeers>, t: Throwable) {
                Log.d("Employeer", "Error in Fetching")

            }
            override fun onResponse(call: Call<employeers>, response: Response<employeers>) {
                if(response.isSuccessful){
                    val intent = Intent(this@LoginActivityEmpleador, HomeActivity::class.java)
                    startActivity(intent)
                }

            }
        })
    }
}