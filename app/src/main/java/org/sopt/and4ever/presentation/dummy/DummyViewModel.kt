package org.sopt.and4ever.presentation.dummy

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.sopt.and4ever.core.util.state.UiState
import org.sopt.and4ever.data.ServicePool
import org.sopt.and4ever.data.model.response.GetDummyUserListResponse
import org.sopt.and4ever.data.service.DummyService

class DummyViewModel : ViewModel() {
    private val dummyService: DummyService = ServicePool.dummyService
    var state: MutableStateFlow<DummyState> = MutableStateFlow(DummyState())
        private set

    fun getDummyList(page: Int) {
        viewModelScope.launch {
            runCatching {
                dummyService.getDummyListUserList(page = page)
            }.onSuccess { response ->
                state.update {
                    it.copy(
                        followers = UiState.Success(response.data.map { user: GetDummyUserListResponse.User ->
                            user.toDummyEntity()
                        }),
                    )
                }
            }
        }
    }
}