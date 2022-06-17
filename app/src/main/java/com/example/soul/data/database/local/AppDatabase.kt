package com.example.soul.data.database.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.soul.data.database.local.dao.UserDao
import com.example.soul.domain.model.User

@Database(entities = [User::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun notesDao(): UserDao
}