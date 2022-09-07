package com.example.aplicationangel.registerAct.local.room

import android.content.Context
import androidx.room.Room

class DataBase(private val context: Context) {
    private var database: DB? = null
    private fun createDatabase() {
        database = Room
            .databaseBuilder(context, DB::class.java, DBConstantes.DB_NAME)
            .allowMainThreadQueries()
            .build()
        if (database!!.isOpen) {
            val pathDB = database!!.openHelper.writableDatabase.path
            print("Ruta de BD: $pathDB")
        }
    }

    fun getDB(): DB {
        if (database == null) {
            createDatabase()
        }
        return database!!
    }
}
