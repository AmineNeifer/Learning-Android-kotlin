package com.example.lista

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    lateinit var name : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        name = findViewById(com.example.lista.R.id.nameText)
    }

    fun connect(v: View) {
        val intent = Intent(this,HomePage::class.java).apply {
            putExtra("name", name.text.toString())
        }

        startActivity(intent)

    }
}