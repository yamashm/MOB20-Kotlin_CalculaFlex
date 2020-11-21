package br.com.calculaflex.presentation.login

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.calculaflex.domain.entity.RequestState
import br.com.calculaflex.domain.entity.User
import br.com.calculaflex.domain.entity.UserLogin
import br.com.calculaflex.domain.usecases.LoginUseCase
import br.com.calculaflex.domain.usecases.ResendPasswordUseCase
import kotlinx.coroutines.launch

class LoginViewModel(
        private val loginUseCase: LoginUseCase,
        private val resendPasswordUseCase: ResendPasswordUseCase
) : ViewModel() {

    val loginState = MutableLiveData<RequestState<User>>()
    val resendPasswordState = MutableLiveData<RequestState<String>>()

    fun doLogin(email: String, password: String) {
        viewModelScope.launch {
            loginState.value = loginUseCase.doLogin(UserLogin(email, password))
        }
    }

    fun resendPassword(email: String) {
        viewModelScope.launch {
            resendPasswordState.value = resendPasswordUseCase.resendPassword(email)
        }
    }
}