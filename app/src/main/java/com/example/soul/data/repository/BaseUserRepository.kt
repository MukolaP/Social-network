package com.example.soul.data.repository

import androidx.lifecycle.LiveData
import com.example.soul.data.database.local.dao.UserDao
import com.example.soul.domain.model.User
import com.example.soul.domain.repositories.user.UserRepository
import javax.inject.Inject

class BaseUserRepository @Inject constructor(private val userDao: UserDao) : UserRepository {
    override fun user(): LiveData<List<User>> = userDao.user()
}
