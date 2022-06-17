package com.example.soul.domain.interactor

import android.content.Context
import android.util.Patterns
import android.widget.Toast
import com.example.soul.core.DoToast
import com.example.soul.domain.model.User
import com.example.soul.domain.repositories.user.UserInsertRepository
import com.example.soul.domain.repositories.user.UserRepository
import javax.inject.Inject

interface RegistrationInteractor {

    suspend fun action(user: User)

    fun validateAccount(user: User): Boolean

    fun validateNickname(nickname: String): Boolean

    fun validatePassword(password: String): Boolean

    fun validateEmailAddress(email: String): Boolean

    class Base @Inject constructor(
        private val userRepository: UserRepository,
        private val userInsertRepository: UserInsertRepository,
        private val toast: DoToast,
        private val context: Context,
    ) : RegistrationInteractor {

        override suspend fun action(user: User) {
            val toastLength = Toast.LENGTH_SHORT

            if (validateAccount(user))
                userInsertRepository.insert(user)

            else if (!validateNickname(user.nickname.toString()))
                toast.doToast(context, nicknameNotValidate, toastLength)

            else if (!validatePassword(user.password.toString()))
                toast.doToast(context, passwordNotValidate, toastLength)

            else if (!validateEmailAddress(user.email.toString()))
                toast.doToast(context, emailNotValidate, toastLength)

        }

        override fun validateAccount(user: User): Boolean =
            validateNickname(user.nickname.toString()) &&
                    validatePassword(user.password.toString()) &&
                    validateEmailAddress(user.email.toString())

        override fun validateNickname(nickname: String): Boolean = nickname.length in 4..16

        override fun validatePassword(password: String): Boolean = password.length in 4..16

        override fun validateEmailAddress(email: String): Boolean =
            email.isNotEmpty() && Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    private companion object {
        const val nicknameNotValidate = "Enter nickname in range 4..16" // Зробити точнішу перевірку
        const val passwordNotValidate = "Enter password in range 4..16" // Зробити точнішу перевірку
        const val emailNotValidate = "There is no such email" // Зробити точнішу перевірку
    }
}