package com.example.aplicationangel.dashAct.domain.usercase

import android.content.Context
import com.example.aplicationangel.dashAct.domain.repository.InfoRepository
import javax.inject.Inject

class InfoUsecase @Inject constructor(
    private val infoRepository: InfoRepository
) {

    suspend operator fun invoke(user: String, context: Context) = infoRepository.info(user, context)
}
