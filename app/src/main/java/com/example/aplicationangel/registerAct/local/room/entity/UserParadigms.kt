package com.example.aplicationangel.registerAct.local.room.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.aplicationangel.registerAct.local.room.DBConstantes.TB_USER

@Entity(tableName = TB_USER)
data class UserParadigms(
    @PrimaryKey
    @ColumnInfo(name = "user")
    val user: String = "",
    @ColumnInfo(name = "name")
    val name: String = "",
    @ColumnInfo(name = "lastname")
    val lastName: String = "",
    @ColumnInfo(name = "secondLastName")
    val secondLastName: String = "",
    @ColumnInfo(name = "birthday")
    val birthday: String = "",
    @ColumnInfo(name = "email")
    val email: String = "",
    @ColumnInfo(name = "gender")
    val gender: String = "",
    @ColumnInfo(name = "state")
    val state: String = "",
    @ColumnInfo(name = "phone")
    val phone: String = "",
    @ColumnInfo(name = "password")
    val password: String = "",
    @ColumnInfo(name = "civil")
    val civil: String = ""
)
