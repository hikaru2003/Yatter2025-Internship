package com.dmm.bootcamp.yatter2025.ui.registerUser

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dmm.bootcamp.yatter2025.common.navigation.Destination
import com.dmm.bootcamp.yatter2025.domain.model.Password
import com.dmm.bootcamp.yatter2025.domain.model.Username
import com.dmm.bootcamp.yatter2025.ui.timeline.publictl.PublicTimelineDestination
import com.dmm.bootcamp.yatter2025.usecase.register.RegisterUserUseCase
import com.dmm.bootcamp.yatter2025.usecase.register.RegisterUserUseCaseResult
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class RegisterUserViewModel(
    private val registerUserUseCase: RegisterUserUseCase,
) : ViewModel() {
    private val _uiState: MutableStateFlow<RegisterUserUiState> = MutableStateFlow(RegisterUserUiState.empty())
    val uiState: StateFlow<RegisterUserUiState> = _uiState.asStateFlow()

    private val _destination = MutableStateFlow<Destination?>(null)
    val destination: StateFlow<Destination?> = _destination.asStateFlow()

    fun onChangeUsername(username: String) {
        val snapshotBindingModel = uiState.value.registerUserBindingModel
        _uiState.update {
            it.copy(
                validUsername = Username(username).validate(),
                registerUserBindingModel = snapshotBindingModel.copy(
                    username = username
                )
            )
        }
    }

    fun onChangePassword(password: String) {
        val snapshotBindingModel = uiState.value.registerUserBindingModel
        _uiState.update {
            it.copy(
                validPassword = Password(password).validate(),
                registerUserBindingModel = snapshotBindingModel.copy(
                    password = password
                )
            )
        }
    }

    fun onClickRegister() {
        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true) }
            Log.d("RegisterUserViewModel", "isLoading true")

            val snapBindingModel = uiState.value.registerUserBindingModel
            when (
                val result =
                    registerUserUseCase.execute(
                        username = snapBindingModel.username,
                        password = snapBindingModel.password,
                    )
            ) {
                is RegisterUserUseCaseResult.Success -> {
//                    パブリックタイムライン画面に遷移
                    _destination.value = PublicTimelineDestination {
                        popUpTo(RegisterUserDestination().route) {
                            inclusive = true
                        }
                    }
                }

                is RegisterUserUseCaseResult.Failure -> {
//                    エラー表示
                    Log.d("RegisterUserViewModel", "onClickRegister Error")
                }
            }

            _uiState.update { it.copy(isLoading = false) }
        }
    }

    fun onClickCancel() {}

    fun onCompleteNavigation() {
        _destination.value = null
    }
}