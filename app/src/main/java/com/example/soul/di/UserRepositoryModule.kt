package com.example.soul.di

import com.example.soul.data.database.local.AppDatabase
import com.example.soul.data.repository.BaseUserInsertRepository
import com.example.soul.data.repository.BaseUserRepository
import com.example.soul.domain.repositories.user.UserInsertRepository
import com.example.soul.domain.repositories.user.UserRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class UserRepositoryModule {

    @Singleton
    @Provides
    fun provideUserRepository(database: AppDatabase): UserRepository =
        BaseUserRepository(database.notesDao())

    @Singleton
    @Provides
    fun provideUserInsertRepository(database: AppDatabase): UserInsertRepository =
        BaseUserInsertRepository(database.notesDao())
}