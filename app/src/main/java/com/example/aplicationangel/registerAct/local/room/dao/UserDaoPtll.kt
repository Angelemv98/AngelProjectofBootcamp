package com.example.aplicationangel.registerAct.local.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.aplicationangel.registerAct.local.room.entity.UserParadigms

@Dao
interface UserDaoPtll {
    @Insert
    suspend fun insertUser(userParadigms: UserParadigms)

    @Query("SELECT * FROM angelUsers")
    suspend fun getUSer(): List<UserParadigms>

    @Query("SELECT name FROM angelUsers where user = :userParameter")
    suspend fun getName(userParameter: String): String

    @Query("DELETE FROM angelUsers")
    suspend fun deleteUSer()

    @Query("UPDATE angelUsers set password= :newPassword WHERE user= :userParameter")
    suspend fun updatePassword(userParameter: String, newPassword: String)
}
