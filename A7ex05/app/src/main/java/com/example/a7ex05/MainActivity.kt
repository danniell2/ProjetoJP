package com.example.a7ex05

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.bumptech.glide.Glide

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var imageView = findViewById<ImageView>(R.id.imgFoto)

        Glide.with(this)
            .load("https://static.itdg.com.br/images/360-240/d1307a2e17cda187df76b78cfd3ac464/shutterstock-2322251819-1-.jpg")
            .into(imageView)
    }
}
