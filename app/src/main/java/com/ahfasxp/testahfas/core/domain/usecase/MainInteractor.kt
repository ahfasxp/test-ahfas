package com.ahfasxp.testahfas.core.domain.usecase

import com.ahfasxp.testahfas.core.domain.repository.IMainRepository

class MainInteractor(private val mainRepository: IMainRepository) : MainUseCase {
    override fun postRegister(
        name: String,
        email: String,
        password: String
    ) = mainRepository.postRegister(name, email, password)

    override fun postLogin(email: String, password: String) =
        mainRepository.postLogin(email, password)

    override fun postLogout(apiToken: String) = mainRepository.postLogout(apiToken)

    override fun getMateries() = mainRepository.getMateries()

    override fun storeMateri(
        apiToken: String,
        name: String,
        content: String,
        createdBy: Int
    ) = mainRepository.storeMateri(apiToken, name, content, createdBy)

    override fun updateMateri(
        apiToken: String,
        id: Int,
        name: String,
        content: String
    ) = mainRepository.updateMateri(apiToken, id, name, content)

    override fun destroyMateri(apiToken: String, id: Int) =
        mainRepository.destroyMateri(apiToken, id)

    override fun getTryouts() = mainRepository.getTryouts()

    override fun storeTryout(
        apiToken: String,
        name: String,
        description: String,
        time: String,
        createdBy: Int
    ) = mainRepository.storeTryout(apiToken, name, description, time, createdBy)

    override fun updateTryout(
        apiToken: String,
        id: Int,
        name: String,
        description: String,
        time: String
    ) = mainRepository.updateTryout(apiToken, id, name, description, time)

    override fun destroyTryout(apiToken: String, id: Int) =
        mainRepository.destroyTryout(apiToken, id)

}