package org.sopt.and4ever.presentation.myping

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
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

    private val _pingFilter = MutableStateFlow(FilterDropDownType.ALL)
    val pingFilter = _pingFilter.asStateFlow()

    val isLoading = MutableStateFlow(true)

    val myPings = pingFilter.flatMapLatest {
        isLoading.value = true
        flow {
            kotlinx.coroutines.delay(200)
            emit(myPingService.fetchMyPingList(it.name.lowercase()))
        }
    }.catch {
        isLoading.value = false
        println("error: $it")
        emit(MyPingList(listOf()))
    }.map {
        isLoading.value = false
        it.pingList
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5_000),
        initialValue = listOf()
    )

    fun setPingFilter(pingFilter: FilterDropDownType) {
        _pingFilter.value = pingFilter
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