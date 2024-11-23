package org.sopt.and4ever.presentation.otherping

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import org.sopt.and4ever.data.service.MyPingService
import org.sopt.and4ever.data.service.OtherPingService
import org.sopt.and4ever.presentation.myping.MyPingViewModel

class OtherPingViewModel(
    private val otherPingService: OtherPingService
): ViewModel() {

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