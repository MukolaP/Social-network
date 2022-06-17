package com.example.soul.data.repository

import com.example.soul.data.database.local.dao.UserDao
import com.example.soul.domain.model.User
import com.example.soul.domain.repositories.user.UserInsertRepository

class BaseUserInsertRepository(private val userDao: UserDao) : UserInsertRepository {
    override suspend fun insert(user: User) = userDao.insert(user)
}