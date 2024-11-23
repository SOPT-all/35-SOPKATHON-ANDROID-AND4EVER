package org.sopt.and4ever.presentation.dummy

import org.sopt.and4ever.core.util.state.UiState
import org.sopt.and4ever.domain.model.DummyEntity

data class DummyState(
    var followers: UiState<List<DummyEntity>> = UiState.Loading,
)
