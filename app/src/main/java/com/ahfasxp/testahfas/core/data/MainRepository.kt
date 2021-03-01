package com.ahfasxp.testahfas.core.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.ahfasxp.testahfas.core.data.source.remote.RemoteDataSource
import com.ahfasxp.testahfas.core.data.source.remote.network.ApiResponse
import com.ahfasxp.testahfas.core.data.source.remote.response.DataMateri
import com.ahfasxp.testahfas.core.data.source.remote.response.DataTryout
import com.ahfasxp.testahfas.core.data.source.remote.response.DataUser
import com.ahfasxp.testahfas.core.domain.model.Materi
import com.ahfasxp.testahfas.core.domain.model.Tryout
import com.ahfasxp.testahfas.core.domain.repository.IMainRepository
import com.ahfasxp.testahfas.core.utils.AppExecutors
import com.ahfasxp.testahfas.core.utils.DataMapper

class MainRepository private constructor(
    private val remoteDataSource: RemoteDataSource,
    private val appExecutors: AppExecutors
) : IMainRepository {

    companion object {
        @Volatile
        private var instance: MainRepository? = null

        fun getInstance(
            remoteData: RemoteDataSource,
            appExecutors: AppExecutors
        ): MainRepository =
            instance ?: synchronized(this) {
                instance ?: MainRepository(remoteData, appExecutors)
            }
    }

    override fun postRegister(
        name: String,
        email: String,
        password: String
    ): LiveData<ApiResponse<DataUser>> {
        return remoteDataSource.postRegister(name, email, password)
    }

    override fun postLogin(
        email: String,
        password: String
    ): LiveData<ApiResponse<DataUser>> {
        return remoteDataSource.postLogin(email, password)
    }

    override fun postLogout(
        apiToken: String
    ): LiveData<ApiResponse<DataUser>> {
        return remoteDataSource.postLogout(apiToken)
    }

    override fun getMateries(): LiveData<List<Materi>> {
        return Transformations.map(remoteDataSource.getMateries()) {
            DataMapper.mapResponsesToDomainMateri(it)
        }
    }

    override fun storeMateri(
        apiToken: String,
        name: String,
        content: String,
        createdBy: Int
    ): LiveData<ApiResponse<DataMateri>> {
        return remoteDataSource.storeMateri(apiToken, name, content, createdBy)
    }

    override fun updateMateri(
        apiToken: String,
        id: Int,
        name: String,
        content: String
    ): LiveData<ApiResponse<DataMateri>> {
        return remoteDataSource.updateMateri(apiToken, id, name, content)
    }

    override fun destroyMateri(
        apiToken: String,
        id: Int,
    ): LiveData<ApiResponse<DataMateri>> {
        return remoteDataSource.destroyMateri(apiToken, id)
    }

    override fun getTryouts(): LiveData<List<Tryout>> {
        return Transformations.map(remoteDataSource.getTryouts()) {
            DataMapper.mapResponsesToDomainTryout(it)
        }
    }

    override fun storeTryout(
        apiToken: String,
        name: String,
        description: String,
        time: String,
        createdBy: Int
    ): LiveData<ApiResponse<DataTryout>> {
        return remoteDataSource.storeTryout(apiToken, name, description, time, createdBy)
    }

    override fun updateTryout(
        apiToken: String,
        id: Int,
        name: String,
        description: String,
        time: String
    ): LiveData<ApiResponse<DataTryout>> {
        return remoteDataSource.updateTryout(apiToken, id, name, description, time)
    }

    override fun destroyTryout(
        apiToken: String,
        id: Int
    ): LiveData<ApiResponse<DataTryout>> {
        return remoteDataSource.destroyTryout(apiToken, id)
    }
}