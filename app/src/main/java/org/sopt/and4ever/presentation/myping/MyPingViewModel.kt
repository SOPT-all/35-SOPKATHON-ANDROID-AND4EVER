package org.sopt.and4ever.presentation.myping

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import org.sopt.and4ever.data.service.MyPingService
import org.sopt.and4ever.domain.model.MyPing
import org.sopt.and4ever.domain.model.MyPingList

class MyPingViewModel(
    private val myPingService: MyPingService
): ViewModel() {

    private val pingFilter = MutableStateFlow("success")

    val myPings = pingFilter.flatMapLatest {
        flow {
            //emit(myPingService.fetchMyPingList(it))
            emit(MyPingList(
                listOf(
                    MyPing(1, "ping1", "2021-10-01", "success"),
                    MyPing(2, "ping2", "2021-10-02", "success"),
                    MyPing(3, "ping3", "2021-10-03", "success"),
                    MyPing(4, "ping4", "2021-10-04", "success"),
                    MyPing(5, "ping5", "2021-10-05", "success"),
                )
            ))
        }
    }.map {
        it.pingList
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5_000),
        initialValue = listOf()
    )

    fun setPingFilter(pingFilter: String) {
        this.pingFilter.value = pingFilter
    }
}

class MyPingViewModelFactory(private val myPingService: MyPingService) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MyPingViewModel::class.java)) {
            return MyPingViewModel(myPingService) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}