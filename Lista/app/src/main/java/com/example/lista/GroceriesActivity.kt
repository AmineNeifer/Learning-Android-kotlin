package com.example.lista

import android.content.Context
import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AlertDialog

class GroceriesActivity : AppCompatActivity() {

    var itemList = ArrayList<String>()
    var fileHelper = FileHelper()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_groceries)

        val sharedPreferences = getSharedPreferences("sharedPref", Context.MODE_PRIVATE)
        val FILENAME = sharedPreferences.getString("name", null) + ".dat"
        var item : EditText = findViewById(R.id.Entry)
        var add : Button = findViewById(R.id.addButton)
        var listView : ListView = findViewById(R.id.list)

        itemList = fileHelper.readData(this, FILENAME)

        var arrayAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, android.R.id.text1, itemList)

        listView.adapter = arrayAdapter

        add.setOnClickListener {
            var itemName : String = item.text.toString()
            if (itemName.isEmpty()) {
                itemName = "milk"
            }
            itemList.add(itemName)
            item.setText("")
            fileHelper.writeData(itemList, applicationContext, FILENAME)
            arrayAdapter.notifyDataSetChanged()
        }

        listView.setOnItemClickListener { adapterView, view, position, l ->
            var alert = AlertDialog.Builder(this)
            alert.setTitle("Delete")
            alert.setMessage("Do you want to delete this item from the list?")
            alert.setCancelable(false)
            alert.setNegativeButton("No", DialogInterface.OnClickListener { dialogInterface, _ ->
                dialogInterface.cancel()
            })

            alert.setPositiveButton("Yes", DialogInterface.OnClickListener { _, _ ->
                itemList.removeAt(position)
                arrayAdapter.notifyDataSetChanged()
                fileHelper.writeData(itemList, applicationContext, FILENAME)
            })

            alert.create().show()
        }
    }
}