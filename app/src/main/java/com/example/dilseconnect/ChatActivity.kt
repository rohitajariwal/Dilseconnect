package com.example.dilseconnect

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView

class ChatActivity : AppCompatActivity() {
    private lateinit var kchat_rv:RecyclerView
    private lateinit var kmsg_box:EditText
    private lateinit var ksend:ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat)

        val name = intent.getStringExtra("name")
        val uid = intent.getStringExtra("uid")

        supportActionBar?.title = name

        kchat_rv = findViewById(R.id.chat_rv)
        kmsg_box = findViewById(R.id.msg_box)
        ksend = findViewById(R.id.send)
    }
}