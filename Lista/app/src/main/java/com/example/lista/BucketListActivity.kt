package com.example.lista

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast

class BucketListActivity : AppCompatActivity() {
    private lateinit var actName : TextView
    private lateinit var actDesc : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bucket_list)
//        val sharedPreferences = getSharedPreferences("sharedPref", Context.MODE_PRIVATE)

    }
    fun insertion() {
        actName = findViewById(R.id.activityName)
        actDesc = findViewById(R.id.activityDesc)
        if (actName.text.toString().isNotEmpty() && actDesc.text.toString().isNotEmpty())  {
            val item = BucketList(actName.text.toString(), actDesc.text.toString())
            Toast.makeText(this, "haya 1", Toast.LENGTH_SHORT).show()
            val db = DataBaseHandler(this)
            Toast.makeText(this, "haya 2", Toast.LENGTH_SHORT).show()
            db.insertData(item)
        } else {
            Toast.makeText(this, "Please fill in both text boxes", Toast.LENGTH_SHORT).show()
        }
    }
}