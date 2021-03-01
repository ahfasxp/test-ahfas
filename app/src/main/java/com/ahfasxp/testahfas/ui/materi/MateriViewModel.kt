package com.ahfasxp.testahfas.ui.materi

import androidx.lifecycle.ViewModel
import com.ahfasxp.testahfas.core.domain.usecase.MainUseCase

class MateriViewModel(private val mainUseCase: MainUseCase) : ViewModel() {
    val getMateries = mainUseCase.getMateries()

    fun storeMateri(
        apiToken: String,
        name: String,
        content: String,
        createdBy: Int
    ) = mainUseCase.storeMateri(apiToken, name, content, createdBy)

    fun updateMateri(
        apiToken: String,
        id: Int,
        name: String,
        content: String
    ) = mainUseCase.updateMateri(apiToken, id, name, content)

    fun destroyMateri(apiToken: String, id: Int) =
        mainUseCase.destroyMateri(apiToken, id)
}