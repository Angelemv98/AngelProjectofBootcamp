package com.example.aplicationangel.dashAct.domain.repository

import android.content.Context
import com.example.aplicationangel.dashAct.data.model.User
import com.example.aplicationangel.dashAct.data.model.toUser
import com.example.aplicationangel.dashAct.data.network.RetrofitClientInfo
import com.example.aplicationangel.registerAct.local.room.DataBase
import javax.inject.Inject

class InfoRepository @Inject constructor() {
    suspend fun info(userLogin: String, context: Context): User {
        val database = DataBase(context).getDB()
        val user = database.daoUserptll().getAllUser(userLogin)
        if (user == null) {
            val userApi = RetrofitClientInfo.api().postdomin(userLogin)
            if (userApi.status) {
                return userApi.user
            } else {
                return User()
            }
        } else {
            return user.toUser()
        }
    }
}
