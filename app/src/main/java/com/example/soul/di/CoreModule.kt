package com.example.soul.di

import android.content.Context
import com.example.soul.core.DoToast
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class CoreModule {

    @Binds
    abstract fun bindContext(@ApplicationContext context: Context): Context

    @Binds
    abstract fun bindToast(toast: DoToast.Base): DoToast
}
