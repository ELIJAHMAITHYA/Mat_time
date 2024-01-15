package com.example.hutsysreens.Presentation.Login

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class LoginScreenViewModel : ViewModel() {
    private val _LoginScreenState = MutableStateFlow(LoginScreenState())
    val loginScreenState = _LoginScreenState.asStateFlow()

    fun onmailChange(email: String) {
        _LoginScreenState.update {
            it.copy(
                email = email
            )
        }
    }

    fun onPasswordChange(password: String) {
        _LoginScreenState.update {
            it.copy(
                password = password
            )
        }
    }

    fun onPasswordClick(isPasswordVisible: Boolean) {
        _LoginScreenState.update {
            it.copy(
                isPasswordVisible = !_LoginScreenState.value.isPasswordVisible
            )
        }
    }

}

data class LoginScreenState(
    val email: String = "",
    val password: String = "",
    val isPasswordVisible: Boolean = false
)