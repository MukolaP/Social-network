package com.example.soul.di

import android.content.Context
import androidx.room.Room
import com.example.soul.app.App
import com.example.soul.data.database.local.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.Dispatchers
import javax.inject.Singleton
import kotlin.coroutines.CoroutineContext

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    private companion object {
        const val DATABASE_NAME = "database"
    }

    @Singleton
    @Provides
    fun provideDatabase(context: Context): AppDatabase =
        Room.databaseBuilder(context, AppDatabase::class.java, DATABASE_NAME)
            .fallbackToDestructiveMigration()
            .build()

    @Provides
    fun provideDispatchers(): CoroutineContext = Dispatchers.IO

    @Singleton
    @Provides
    fun provideApplication(app: Context): App {
        return app as App
    }
}