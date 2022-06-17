package com.example.soul.domain.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user")
data class User(
    @PrimaryKey(autoGenerate = true) val uid: Int = 0,
    @ColumnInfo(name = "nickname") val nickname: String? = "",
    @ColumnInfo(name = "password") val password: String? = "",
    @ColumnInfo(name = "email") val email: String? = "",
)
