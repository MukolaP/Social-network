package com.example.soul.domain.repositories.user

import com.example.soul.domain.model.User

interface UserInsertRepository {
    suspend fun insert(user: User)
}