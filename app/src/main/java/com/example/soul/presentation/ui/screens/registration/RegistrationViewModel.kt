package com.example.soul.presentation.ui.screens.registration

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.example.soul.domain.interactor.RegistrationInteractor
import com.example.soul.domain.model.User
import com.example.soul.navigation.NavigationTree
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

@HiltViewModel
class RegistrationViewModel @Inject constructor(
    private val interactor: RegistrationInteractor,
    private val dispatcher: CoroutineContext
) : ViewModel() {

    fun validateAccount(navController: NavController, user: User) {
        viewModelScope.launch(dispatcher) {
            interactor.action(user)
        }
        if (interactor.validateAccount(user))
            navController.navigate(NavigationTree.Login.name)
    }
}