package com.example.simpleandroidapp.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class LoginViewModel : ViewModel() {

    private val _loginValidation = MutableLiveData<ViewState>()
    val loginValidation: LiveData<ViewState> = _loginValidation

    fun performLogin(username: String, password: String) {
        viewModelScope.launch {
            if (username.isEmpty()) {
                _loginValidation.value = ViewState.NoUsername
            }
            else if (password == "password") {
                _loginValidation.value = ViewState.SuccessfulLogin(
                    username = username
                )
            } else {
                _loginValidation.value = ViewState.WrongPassword
            }
        }
    }

    sealed class ViewState {
        object NoUsername: ViewState()
        object WrongPassword: ViewState()
        data class SuccessfulLogin(
            val username: String
        ): ViewState()
    }
}