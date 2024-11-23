package org.sopt.and4ever.presentation.mypingdetail

sealed class MyPingDetailSideEffect {
    data class ShowToast(val message: String) : MyPingDetailSideEffect()
}