package com.example.aplicationangel.dashAct.domain.usercase

import android.content.Context
import com.example.aplicationangel.dashAct.domain.repository.InfoRepository

class InfoUsecase {
    private val infoRepository = InfoRepository()

    suspend operator fun invoke(user: String, context: Context) = infoRepository.info(user, context)
}
