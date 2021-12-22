package com.example.lista

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast

val DATABASE_NAME = "BucketDB"
val COL_ID = "id"
val COL_ACT = "activity"
val COL_DESC = "description"

class DataBaseHandler(var context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, 1) {
//    val sharedPreferences = context.getSharedPreferences("sharedPref", Context.MODE_PRIVATE)
//    val TABLE_NAME = sharedPreferences.getString("name", null)
    private val TABLE_NAME = "random"
    override fun onCreate(db: SQLiteDatabase?) {
        val createTable = "CREATE TABLE " + TABLE_NAME + " (" +
                COL_ID + "INTEGER PRIMARY KEY AUTOINCREMENT," +
                COL_ACT + "VARCHAR(256)," +
                COL_DESC + "MEDIUMTEXT"
        db?.execSQL(createTable)
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        TODO("Not yet implemented")
    }
    
    fun insertData(item : BucketList) {
        val db = this.writableDatabase
        val cv = ContentValues()
        cv.put(COL_ACT, item.activity)
        cv.put(COL_DESC, item.desc)
        val result = db.insert(TABLE_NAME, null, cv)
        if (result == (-1).toLong())
            Toast.makeText(context, "FAILED", Toast.LENGTH_SHORT).show()
        else
            Toast.makeText(context, "Success", Toast.LENGTH_SHORT).show()


    }

}