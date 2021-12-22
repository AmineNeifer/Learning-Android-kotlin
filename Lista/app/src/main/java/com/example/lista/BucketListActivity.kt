package com.example.lista

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class BucketListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bucket_list)
        val sharedPreferences = getSharedPreferences("sharedPref", Context.MODE_PRIVATE)

    }
}