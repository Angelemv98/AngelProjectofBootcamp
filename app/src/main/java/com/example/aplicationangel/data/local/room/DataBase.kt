package com.example.aplicationangel.data.local.room

import android.content.Context
import androidx.room.Room

class DataBase(private val context: Context) {
    private var dataBase: DB? = null
    private fun createDatabase() {
        dataBase = Room
            .databaseBuilder(context, DB::class.java, DbConstant.DB_NAME)
            .allowMainThreadQueries()
            .build()
        if (dataBase!!.isOpen) {
            val pathDB = dataBase!!.openHelper.writableDatabase.path
            print("DB PATH: $pathDB")
        }
    }

    fun getDB(): DB {
        if (dataBase == null) {
            createDatabase()
        }
        return dataBase!!
    }
}
