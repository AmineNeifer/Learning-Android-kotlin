package com.example.lista

import android.content.Context
import java.io.*

class FileHelper {

    val FILENAME = "listinfo.dat"

    fun writeData(item : ArrayList<String>, context: Context, filename: String) {
        var fos : FileOutputStream = context.openFileOutput(filename, Context.MODE_PRIVATE)

        var oas = ObjectOutputStream(fos)

        oas.writeObject(item)
        oas.close()
    }

    fun readData(context: Context, filename: String) : ArrayList<String> {
        var itemList : ArrayList<String>

        try {
            var fis : FileInputStream = context.openFileInput(filename)
            var ois = ObjectInputStream(fis)
            itemList = ois.readObject() as ArrayList<String>
        } catch (e : FileNotFoundException) {
            itemList = ArrayList()
        }
        return itemList
    }


}