package org.sopt.and4ever.presentation.mypingdetail

import org.sopt.and4ever.core.util.state.UiState
import org.sopt.and4ever.data.model.response.GetPingDetail

data class MyPingState(
    val pingDetail: UiState<GetPingDetail> = UiState.Loading,
    val pingStatus: String = "pending",
)
