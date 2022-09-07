package com.example.aplicationangel.registerAct.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.aplicationangel.registerAct.local.room.dao.UserDaoPtll
import com.example.aplicationangel.registerAct.local.room.entity.UserParadigms

@Database(
    entities = [
        UserParadigms::class
    ],
    version = 1
)

abstract class DB : RoomDatabase() {
    abstract fun daoUser(): UserDaoPtll
}
