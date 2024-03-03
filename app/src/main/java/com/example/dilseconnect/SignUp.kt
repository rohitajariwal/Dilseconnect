package com.example.dilseconnect

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.health.UidHealthStats
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class SignUp : AppCompatActivity() {
    private lateinit var kedt_name: EditText
    private lateinit var kedt_email: EditText
    private lateinit var kedt_pass: EditText
    private lateinit var kbtn_login: Button
    private lateinit var kbtn_signup: Button
    private lateinit var mAuth: FirebaseAuth
    private lateinit var mDbRef: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        supportActionBar?.hide()

        mAuth = FirebaseAuth.getInstance()

        kedt_name = findViewById(R.id.edt_name)
        kedt_email = findViewById(R.id.edt_email)
        kedt_pass = findViewById(R.id.edt_pass)
        kbtn_login = findViewById(R.id.btn_login)
        kbtn_signup = findViewById(R.id.btn_signup)

        kbtn_login.setOnClickListener {
            val intent = Intent(this, Login::class.java)
            startActivity(intent)
        }

        kbtn_signup.setOnClickListener {
            val name = kedt_name.text.toString()
            val email = kedt_email.text.toString()
            val password = kedt_pass.text.toString()

            signUp(name, email, password)
        }
    }

    private fun signUp(name:String, email:String, password:String){

        mAuth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {

                    addUserToDatabase(name,email,mAuth.currentUser?.uid!!)
                    val intent = Intent(this@SignUp, MainActivity::class.java)
                    finish()
                    startActivity(intent)

                } else {
                    Toast.makeText(this@SignUp, "Some error occurred", Toast.LENGTH_SHORT).show()
                }
            }

    }

    private fun addUserToDatabase(name: String,email: String, uid: String){
            mDbRef = FirebaseDatabase.getInstance().getReference()
            mDbRef.child("user").child(uid).setValue(User(name, email, uid))
    }
}
