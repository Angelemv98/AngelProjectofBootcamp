package com.example.aplicationangel.di

import com.example.aplicationangel.dashAct.domain.repository.InfoRepository
import com.example.aplicationangel.dashAct.domain.usercase.InfoUsecase
import com.example.aplicationangel.dashAct.presentation.viewmodel.ActDashViewModel
import com.example.aplicationangel.domain.repositry.LoginRepository
import com.example.aplicationangel.domain.usecase.LoginUseCase
import com.example.aplicationangel.presentation.viewmodel.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModuleLogin = module {
    // Reposiory
    single { LoginRepository() }
    // Use case
    single { LoginUseCase(get()) }
    // Viewmodel
    viewModel { MainViewModel(get()) }
}

val appModuleDashboard = module {
    // repository
    single { InfoRepository() }
    // Info Usecase
    single { InfoUsecase(get()) }
    // viewmodel
    viewModel { ActDashViewModel(get()) }
}
