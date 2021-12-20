package com.example.lista

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class HomePage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_page)


        // Get the Intent that started this activity and extract the string
        val message = intent.getStringExtra("name")

        // Capture the layout's TextView and set the string as its text
        val textView = findViewById<TextView>(R.id.nameText1).apply {
            text = message
        }

    }
}