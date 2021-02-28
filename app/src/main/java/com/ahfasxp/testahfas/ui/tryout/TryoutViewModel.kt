package com.ahfasxp.testahfas.ui.tryout

import androidx.lifecycle.ViewModel
import com.ahfasxp.testahfas.core.domain.usecase.MainUseCase

class TryoutViewModel(mainUseCase: MainUseCase) : ViewModel() {
    val getTryouts = mainUseCase.getTryouts()

//    fun storeTryout(
//        apiToken: String,
//        name: String,
//        description: String,
//        time: String,
//        createdBy: Int
//    ) = mainUseCase.storeTryout(apiToken, name, description, time, createdBy)
//
//    fun updateTryout(
//        apiToken: String,
//        id: Int,
//        name: String,
//        description: String,
//        time: String
//    ) = mainUseCase.updateTryout(apiToken, id, name, description, time)
//
//    fun destroyTryout(apiToken: String, id: Int) =
//        mainUseCase.destroyTryout(apiToken, id)
}