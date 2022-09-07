package com.example.aplicationangel.data.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.aplicationangel.data.local.room.dao.UserDao
import com.example.aplicationangel.data.local.room.entity.UserEntity

@Database(
    entities = [
        UserEntity::class
    ],
    version = 1
)
abstract class DB : RoomDatabase() {
    abstract fun daoUser(): UserDao
}
