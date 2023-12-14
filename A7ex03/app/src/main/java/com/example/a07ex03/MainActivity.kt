package com.example.a07ex03

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Inicializa os botões
        val browserButton = findViewById<FloatingActionButton>(R.id.browserButton)
        val callButton = findViewById<FloatingActionButton>(R.id.callButton)
        val smsButton = findViewById<FloatingActionButton>(R.id.smsButton)
        val emailButton = findViewById<FloatingActionButton>(R.id.emailButton)

        // Define as ações dos botões
        browserButton.setOnClickListener {
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com")))
        }
        callButton.setOnClickListener {
            startActivity(Intent(Intent.ACTION_DIAL, Uri.parse("tel:123456789")))
        }
        smsButton.setOnClickListener {
            startActivity(Intent(Intent.ACTION_SENDTO, Uri.parse("sms:123456789")))
        }
        emailButton.setOnClickListener {
            startActivity(Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:example@example.com")))
        }
    }
}

