package org.sopt.and4ever.presentation.mypingdetail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.sopt.and4ever.core.util.state.UiState
import org.sopt.and4ever.data.model.request.PatchPingRequest
import org.sopt.and4ever.data.model.response.GetPingDetail
import org.sopt.and4ever.data.service.MyPingDetailService

class MyPingDetailViewModel(
    private val myPingDetailService: MyPingDetailService,
) : ViewModel() {
    var myPingState = MutableStateFlow(MyPingState())
        private set

    var myPingDetailSideEffect = MutableSharedFlow<MyPingDetailSideEffect>()
        private set

    fun patchPingStatus(
        pingId: Int,
        pingStatus: String,
    ) {
        viewModelScope.launch {
            runCatching {
                myPingDetailService.patchPingStatus(
                    pingId = pingId,
                    pingStatus = PatchPingRequest(pingStatus)
                )
            }.onSuccess {
                myPingDetailSideEffect.emit(
                    MyPingDetailSideEffect.ShowToast(
                        if (pingStatus == "success")
                            "완벽한 핑계였군요!"
                        else "더 좋은 핑계를 준비해드릴게요 ㅠㅠ"
                    )
                )
            }
        }
    }

    fun getPingDetail(
        pingId: Int,
    ) {
        viewModelScope.launch {
            runCatching {
                with(myPingDetailService.getPingDetail(pingId)) {
                    myPingState.update {
                        it.copy(
                            pingDetail = UiState.Success(
                                GetPingDetail(
                                    situation = situation,
                                    ping = ping,
                                    pingStatus = pingStatus,
                                    createdDate = createdDate,
                                )
                            )
                        )
                    }
                    updatePingStatus(pingStatus)
                }
            }
        }
    }

    fun updatePingStatus(pingStatus: String) {
        myPingState.update {
            it.copy(
                pingStatus = pingStatus
            )
        }
    }
}

class MyPingDetailViewModelFactory(private val myPingDetailService: MyPingDetailService) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MyPingDetailViewModel::class.java)) {
            return MyPingDetailViewModel(myPingDetailService) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}