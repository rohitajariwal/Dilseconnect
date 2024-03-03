package com.example.dilseconnect

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class Login : AppCompatActivity() {
    private  lateinit var kedt_email: EditText
    private  lateinit var kedt_pass: EditText
    private  lateinit var kbtn_login: Button
    private  lateinit var kbtn_signup: Button
    private lateinit var mAuth:FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        supportActionBar?.hide()

        mAuth= FirebaseAuth.getInstance()

        kedt_email = findViewById(R.id.edt_email)
        kedt_pass = findViewById(R.id.edt_pass)
        kbtn_login = findViewById(R.id.btn_login)
        kbtn_signup = findViewById(R.id.btn_signup)

        kbtn_signup.setOnClickListener {
            val intent = Intent(this, SignUp::class.java)
            startActivity(intent)
        }

        kbtn_login.setOnClickListener {
            val email = kedt_email.text.toString()
            val password = kedt_pass.text.toString()

            login(email,password)
        }
    }

    private fun login(email: String,password: String){

        mAuth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {

                    val intent = Intent(this@Login, MainActivity::class.java)
                    finish()
                    startActivity(intent)

                } else {
                    Toast.makeText(this@Login, "User does not exist",Toast.LENGTH_SHORT).show()
                }
            }


    }
}