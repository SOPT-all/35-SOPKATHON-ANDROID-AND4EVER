package org.sopt.and4ever.presentation.result

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import org.sopt.and4ever.data.model.request.PingRequest
import org.sopt.and4ever.data.model.request.SelectRequest
import org.sopt.and4ever.data.service.MyPingService
import org.sopt.and4ever.data.service.PingService
import org.sopt.and4ever.presentation.myping.MyPingViewModel
import retrofit2.HttpException
import java.net.HttpURLConnection

class ResultViewModel(
    private val pingService: PingService
) : ViewModel() {
    private val _uiState = MutableStateFlow<ResultUiState>(ResultUiState.Initial)
    val uiState: StateFlow<ResultUiState> = _uiState.asStateFlow()

    fun generatePing(situation: String) {
        viewModelScope.launch {
            _uiState.value = ResultUiState.Loading
            try {
                val response = pingService.generatePing(
                    request = PingRequest(situation)
                )
                _uiState.value = ResultUiState.Success(situation, response.ping)
            } catch (e: HttpException) {
                handleError(e)
            } catch (e: Exception) {
                _uiState.value = ResultUiState.Error("핑계 생성에 실패했습니다.")
            }
        }
    }

    fun refreshPing(situation: String) {
        generatePing(situation)
    }

    fun selectPing() {
        viewModelScope.launch {
            val currentState = _uiState.value
            if (currentState is ResultUiState.Success) {
                try {
                    val response = pingService.selectPing(
                        request = SelectRequest(
                            situation = currentState.situation,
                            ping = currentState.ping
                        )
                    )
                    _uiState.value = ResultUiState.Selected(response.message)
                } catch (e: HttpException) {
                    handleError(e)
                } catch (e: Exception) {
                    _uiState.value = ResultUiState.Error("핑계 선택에 실패했습니다.")
                }
            }
        }
    }

    private fun handleError(e: HttpException) {
        val errorMessage = when (e.code()) {
            HttpURLConnection.HTTP_BAD_REQUEST -> "요청 문자열의 길이는 1자 이상 200 이하여야 합니다."
            else -> "서버 내부 오류입니다."
        }
        _uiState.value = ResultUiState.Error(errorMessage)
    }
}

sealed interface ResultUiState {
    object Initial : ResultUiState
    object Loading : ResultUiState
    data class Selected(val message: String) : ResultUiState
    data class Success(
        val situation: String,
        val ping: String
    ) : ResultUiState
    data class Error(val message: String) : ResultUiState
}

class ResultModelFactory(private val myPingService: PingService) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ResultViewModel::class.java)) {
            return ResultViewModel(myPingService) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
