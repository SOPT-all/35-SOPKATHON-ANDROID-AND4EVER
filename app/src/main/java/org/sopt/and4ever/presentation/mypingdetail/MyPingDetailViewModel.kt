package org.sopt.and4ever.presentation.mypingdetail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch
import org.sopt.and4ever.data.service.MyPingDetailService
import org.sopt.and4ever.presentation.myping.MyPingViewModel

class MyPingDetailViewModel(
    private val myPingDetailService: MyPingDetailService,
) : ViewModel() {
    var myPingDetailSideEffect = MutableSharedFlow<MyPingDetailSideEffect>()
        private set

    fun patchPingStatus(
        pingId: Int,
        pingStatus: String,
    ) {
        viewModelScope.launch {
            runCatching {
                myPingDetailService.patchPingStatus(pingId = pingId, pingStatus = pingStatus)
            }.onSuccess {
                myPingDetailSideEffect.emit(MyPingDetailSideEffect.ShowToast("완벽한 핑계였군요!"))
            }.onFailure {
                myPingDetailSideEffect.emit(MyPingDetailSideEffect.ShowToast("더 좋은 핑계를 준비해드릴게요 ㅠㅠ"))
            }
        }
    }
}

class MyPingDetailViewModelFactory(private val myPingDetailService: MyPingDetailService) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MyPingViewModel::class.java)) {
            return MyPingDetailViewModel(myPingDetailService) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}