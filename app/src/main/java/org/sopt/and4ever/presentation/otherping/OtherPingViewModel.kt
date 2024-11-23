package org.sopt.and4ever.presentation.otherping

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import org.sopt.and4ever.data.service.OtherPingService

class OtherPingViewModel(
    private val otherPingService: OtherPingService
): ViewModel() {

    val isLoading = MutableStateFlow(true)

    private val _uiState = MutableStateFlow(OtherPingUiState())
    val uiState: StateFlow<OtherPingUiState> = _uiState.asStateFlow()

    fun getOtherPingList(){
        isLoading.value = true
        viewModelScope.launch{
            runCatching {
                otherPingService.getOtherPingList()
            }.onSuccess { pingList ->
                isLoading.value = false
                Log.d("zzzzzzzz", pingList.toString())
                _uiState.value = _uiState.value.copy(pingList = pingList.pingList)
            }.onFailure { error ->
                isLoading.value = false
                Log.e("ㅋㅋ", error.toString())
            }
        }
    }
}

class OtherPingViewModelFactory(private val otherPingService: OtherPingService) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(OtherPingViewModel::class.java)) {
            return OtherPingViewModel(otherPingService) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}