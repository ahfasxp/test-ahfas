package com.ahfasxp.testahfas.core.ui

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.ahfasxp.testahfas.core.di.Injection
import com.ahfasxp.testahfas.core.domain.usecase.MainUseCase
import com.ahfasxp.testahfas.ui.auth.AuthViewModel
import com.ahfasxp.testahfas.ui.materi.MateriViewModel
import com.ahfasxp.testahfas.ui.tryout.TryoutViewModel

class ViewModelFactory private constructor(private val mainUseCase: MainUseCase) :
    ViewModelProvider.NewInstanceFactory() {

    companion object {
        @Volatile
        private var instance: ViewModelFactory? = null

        fun getInstance(context: Context): ViewModelFactory =
            instance ?: synchronized(this) {
                instance ?: ViewModelFactory(Injection.provideMainUseCase(context))
            }
    }

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T =
        when {
            modelClass.isAssignableFrom(AuthViewModel::class.java) -> {
                AuthViewModel(mainUseCase) as T
            }
            modelClass.isAssignableFrom(MateriViewModel::class.java) -> {
                MateriViewModel(mainUseCase) as T
            }
            modelClass.isAssignableFrom(TryoutViewModel::class.java) -> {
                TryoutViewModel(mainUseCase) as T
            }
            else -> throw Throwable("Unknown ViewModel class: " + modelClass.name)
        }
}