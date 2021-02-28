package com.ahfasxp.testahfas.ui.auth

import androidx.lifecycle.ViewModel
import com.ahfasxp.testahfas.core.domain.usecase.MainUseCase

class AuthViewModel(private val mainUseCase: MainUseCase) : ViewModel() {
    fun postRegister(
        name: String,
        email: String,
        password: String
    ) = mainUseCase.postRegister(name, email, password)

    fun postLogin(email: String, password: String) =
        mainUseCase.postLogin(email, password)

    fun postLogout(apiToken: String) = mainUseCase.postLogout(apiToken)
}