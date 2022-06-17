package com.example.soul.domain.repositories.user

import androidx.lifecycle.LiveData
import com.example.soul.domain.model.User

interface UserRepository {
    fun user(): LiveData<List<User>>
}