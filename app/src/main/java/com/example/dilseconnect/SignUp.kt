package com.example.dilseconnect

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.google.firebase.auth.FirebaseAuth

class SignUp : AppCompatActivity() {
    private lateinit var kedt_name: EditText
    private lateinit var kedt_email: EditText
    private lateinit var kedt_pass: EditText
    private lateinit var kbtn_login: Button
    private lateinit var kbtn_signup: Button
    private lateinit var mAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        mAuth = FirebaseAuth.getInstance()

        kedt_name = findViewById(R.id.edt_name)
        kedt_email = findViewById(R.id.edt_email)
        kedt_pass = findViewById(R.id.edt_pass)
        kbtn_login = findViewById(R.id.btn_login)
        kbtn_signup = findViewById(R.id.btn_signup)

        kbtn_login.setOnClickListener {
            val intent = Intent(this, SignUp::class.java)
            startActivity(intent)
        }

        kbtn_signup.setOnClickListener {
            val email = kedt_email.text.toString()
            val password = kedt_pass.text.toString()

            signUp(email,password)
        }
    }

    private fun signUp(email:String,password:String){

    }
}
