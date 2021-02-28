package com.ahfasxp.testahfas.core.di

import android.content.Context
import com.ahfasxp.testahfas.core.data.MainRepository
import com.ahfasxp.testahfas.core.data.source.remote.RemoteDataSource
import com.ahfasxp.testahfas.core.data.source.remote.network.ApiConfig
import com.ahfasxp.testahfas.core.domain.repository.IMainRepository
import com.ahfasxp.testahfas.core.domain.usecase.MainInteractor
import com.ahfasxp.testahfas.core.domain.usecase.MainUseCase
import com.ahfasxp.testahfas.core.utils.AppExecutors

object Injection {
    private fun provideRepository(context: Context): IMainRepository {

        val remoteDataSource = RemoteDataSource.getInstance(ApiConfig.provideApiService())
        val appExecutors = AppExecutors()

        return MainRepository.getInstance(remoteDataSource, appExecutors)
    }

    fun provideMainUseCase(context: Context): MainUseCase {
        val repository = provideRepository(context)
        return MainInteractor(repository)
    }
}