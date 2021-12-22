package com.example.lista

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class HomePage : AppCompatActivity() {

    lateinit var name: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_page)

        val sharedPreferences = getSharedPreferences("sharedPref", Context.MODE_PRIVATE)

        name = findViewById<TextView>(R.id.nameText1).apply {
            text = sharedPreferences.getString("name", null)
        }
    }

    fun groceriesConnect(v: View) {

        val intent = Intent(this, GroceriesActivity::class.java)
//            .apply {
//            putExtra("name", name.text.toString())
//        }
        startActivity(intent)
    }
}