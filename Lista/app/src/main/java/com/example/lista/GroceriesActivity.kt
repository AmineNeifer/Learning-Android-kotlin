package com.example.lista

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class GroceriesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_groceries)

        val sharedPreferences = getSharedPreferences("sharedPref", Context.MODE_PRIVATE)

    }
}