package com.example.todolist

import android.app.AlertDialog
import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView

class MainActivity : AppCompatActivity() {

    var itemList = ArrayList<String>()
    var fileHelper = FileHelper()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var item : EditText = findViewById(R.id.editText)
        var add : Button = findViewById(R.id.button)
        var listView : ListView = findViewById(R.id.list)

        itemList = fileHelper.readData(this)

        var arrayAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, android.R.id.text1, itemList)

        listView.adapter = arrayAdapter

        add.setOnClickListener {
            var itemName : String = item.text.toString()
            itemList.add(itemName)
            item.setText("")
            fileHelper.writeData(itemList, applicationContext)
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
                fileHelper.writeData(itemList, applicationContext)
            })

            alert.create().show()
        }
    }

}