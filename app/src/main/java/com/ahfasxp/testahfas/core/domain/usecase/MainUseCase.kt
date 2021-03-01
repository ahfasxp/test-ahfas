package com.ahfasxp.testahfas.core.domain.usecase

import androidx.lifecycle.LiveData
import com.ahfasxp.testahfas.core.data.source.remote.network.ApiResponse
import com.ahfasxp.testahfas.core.data.source.remote.response.DataMateri
import com.ahfasxp.testahfas.core.data.source.remote.response.DataTryout
import com.ahfasxp.testahfas.core.data.source.remote.response.DataUser
import com.ahfasxp.testahfas.core.domain.model.Materi
import com.ahfasxp.testahfas.core.domain.model.Tryout

interface MainUseCase {
    fun postRegister(name: String, email: String, password: String): LiveData<ApiResponse<DataUser>>
    fun postLogin(email: String, password: String): LiveData<ApiResponse<DataUser>>
    fun postLogout(apiToken: String): LiveData<ApiResponse<DataUser>>

    fun getMateries(): LiveData<List<Materi>>
    fun storeMateri(
        apiToken: String,
        name: String,
        content: String,
        createdBy: Int
    ): LiveData<ApiResponse<DataMateri>>

    fun updateMateri(
        apiToken: String,
        id: Int,
        name: String,
        content: String
    ): LiveData<ApiResponse<DataMateri>>

    fun destroyMateri(apiToken: String, id: Int): LiveData<ApiResponse<DataMateri>>

    fun getTryouts(): LiveData<List<Tryout>>
    fun storeTryout(
        apiToken: String,
        name: String,
        description: String,
        time: String,
        createdBy: Int
    ): LiveData<ApiResponse<DataTryout>>

    fun updateTryout(
        apiToken: String,
        id: Int,
        name: String,
        description: String,
        time: String
    ): LiveData<ApiResponse<DataTryout>>

    fun destroyTryout(apiToken: String, id: Int): LiveData<ApiResponse<DataTryout>>
}