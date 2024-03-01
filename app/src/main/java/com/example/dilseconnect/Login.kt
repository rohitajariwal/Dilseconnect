package com.example.dilseconnect

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class Login : AppCompatActivity() {

    private lateinit var kedt_email:EditText
    private lateinit var kedt_pass:EditText
    private lateinit var kbtn_login:Button
    private lateinit var kbtn_signup:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        kedt_email=findViewById(R.id.edt_email)
        kedt_pass=findViewById(R.id.edt_pass)
        kbtn_login=findViewById(R.id.btn_login)
        kbtn_signup=findViewById(R.id.btn_signup)

        kbtn_signup.setOnClickListener {
            val i=Intent(this, SignUp::class.java)
            startActivity(i)
        }

    }
}