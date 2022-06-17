package com.example.soul.di

import android.content.Context
import com.example.soul.core.DoToast
import com.example.soul.domain.interactor.RegistrationInteractor
import com.example.soul.domain.repositories.user.UserInsertRepository
import com.example.soul.domain.repositories.user.UserRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class DomainModule {

    @Provides
    fun provideRegistrationInteractor(
        userRepository: UserRepository,
        userInsertRepository: UserInsertRepository,
        toast: DoToast,
        context: Context
    ): RegistrationInteractor =
        RegistrationInteractor.Base(
            userRepository = userRepository,
            userInsertRepository = userInsertRepository,
            toast = toast,
            context = context
        )
}