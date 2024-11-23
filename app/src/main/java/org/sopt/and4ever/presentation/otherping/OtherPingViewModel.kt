package org.sopt.and4ever.presentation.otherping

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import org.sopt.and4ever.data.service.OtherPingService

class OtherPingViewModel(
    private val otherPingService: OtherPingService
): ViewModel() {

    fun getOtherPingList(){
        viewModelScope.launch{
            runCatching {
                otherPingService.getOtherPingList()
            }.onSuccess {

            }.onFailure {

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