package com.example.aplicationangel.data.local.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.aplicationangel.data.local.room.entity.UserEntity

@Dao
interface UserDao {

    @Insert
    suspend fun insertUser(userEntity: UserEntity)

    @Query("SELECT * FROM user")
    suspend fun getUSer(): List<UserEntity>

    @Query("SELECT name FROM user where user = :userParameter")
    suspend fun getName(userParameter: String): String

    @Query("DELETE FROM user")
    suspend fun deleteUSer()

    @Query("UPDATE user set password= :newPassword WHERE user= :userParameter")
    suspend fun updatePassword(userParameter: String, newPassword: String)
}
