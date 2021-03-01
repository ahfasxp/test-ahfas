package com.ahfasxp.testahfas.core.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.ahfasxp.testahfas.core.data.source.remote.RemoteDataSource
import com.ahfasxp.testahfas.core.domain.model.Materi
import com.ahfasxp.testahfas.core.domain.model.Tryout
import com.ahfasxp.testahfas.core.domain.model.User
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
    ): LiveData<User> {
        return Transformations.map(remoteDataSource.postRegister(name, email, password)) {
            DataMapper.mapResponsesToDomainUser(it)
        }
    }

    override fun postLogin(
        email: String,
        password: String
    ): LiveData<User> {
        return Transformations.map(remoteDataSource.postLogin(email, password)) {
            DataMapper.mapResponsesToDomainUser(it)
        }
    }

    override fun postLogout(
        apiToken: String
    ): LiveData<User> {
        return Transformations.map(remoteDataSource.postLogout(apiToken)) {
            DataMapper.mapResponsesToDomainUser(it)
        }
    }

    override fun getMateries(): LiveData<List<Materi>> {
        return Transformations.map(remoteDataSource.getMateries()) {
            DataMapper.mapResponsesToDomainMateriList(it)
        }
    }

    override fun storeMateri(
        apiToken: String,
        name: String,
        content: String,
        createdBy: Int
    ): LiveData<Materi> {
        return Transformations.map(
            remoteDataSource.storeMateri(
                apiToken,
                name,
                content,
                createdBy
            )
        ) {
            DataMapper.mapResponsesToDomainMateri(it)
        }
    }

    override fun updateMateri(
        apiToken: String,
        id: Int,
        name: String,
        content: String
    ): LiveData<Materi> {
        return Transformations.map(
            remoteDataSource.updateMateri(apiToken, id, name, content)
        ) {
            DataMapper.mapResponsesToDomainMateri(it)
        }
    }

    override fun destroyMateri(
        apiToken: String,
        id: Int,
    ): LiveData<Materi> {
        return Transformations.map(
            remoteDataSource.destroyMateri(apiToken, id)
        ) {
            DataMapper.mapResponsesToDomainMateri(it)
        }
    }

    override fun getTryouts(): LiveData<List<Tryout>> {
        return Transformations.map(remoteDataSource.getTryouts()) {
            DataMapper.mapResponsesToDomainTryoutList(it)
        }
    }

    override fun storeTryout(
        apiToken: String,
        name: String,
        description: String,
        time: String,
        createdBy: Int
    ): LiveData<Tryout> {
        return Transformations.map(
            remoteDataSource.storeTryout(
                apiToken,
                name,
                description,
                time,
                createdBy
            )
        ) {
            DataMapper.mapResponsesToDomainTryout(it)
        }
    }

    override fun updateTryout(
        apiToken: String,
        id: Int,
        name: String,
        description: String,
        time: String
    ): LiveData<Tryout> {
        return Transformations.map(
            remoteDataSource.updateTryout(apiToken, id, name, description, time)
        ) {
            DataMapper.mapResponsesToDomainTryout(it)
        }
    }

    override fun destroyTryout(
        apiToken: String,
        id: Int
    ): LiveData<Tryout> {
        return Transformations.map(
            remoteDataSource.destroyTryout(apiToken, id)
        ) {
            DataMapper.mapResponsesToDomainTryout(it)
        }
    }
}