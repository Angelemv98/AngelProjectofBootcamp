package com.example.aplicationangel.dashAct.presentation.viewmodel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.aplicationangel.dashAct.data.model.User
import com.example.aplicationangel.dashAct.domain.usercase.InfoUsecase
import kotlinx.coroutines.launch

class ActDashViewModel : ViewModel() {

    private val infoUsecase = InfoUsecase()

    private var _stateInfo: MutableLiveData<User> = MutableLiveData()
    val stateInfo: LiveData<User> get() = _stateInfo

    fun perfilData(user: String, context: Context) {
        println("$user")
        viewModelScope.launch {
            val response = infoUsecase(user, context)
            _stateInfo.postValue(response)
        }
    }
}
