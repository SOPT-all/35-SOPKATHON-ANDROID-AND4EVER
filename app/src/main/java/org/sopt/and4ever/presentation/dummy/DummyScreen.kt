package org.sopt.and4ever.presentation.dummy

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.LocalLifecycleOwner
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import org.sopt.and4ever.core.util.state.UiState
import org.sopt.and4ever.domain.model.DummyEntity

@Composable
fun DummyRoute() {
    val lifecycleOwner = LocalLifecycleOwner.current
    val viewModel: DummyViewModel = viewModel()


    val state by viewModel.state.collectAsStateWithLifecycle(lifecycleOwner = lifecycleOwner)

    LaunchedEffect(key1 = true) {
        viewModel.getDummyList(2)
    }

    when (state.followers) {
        is UiState.Empty -> {}
        is UiState.Loading -> {}
        is UiState.Failure -> {}
        is UiState.Success -> {
            DummyScreen(dummyList = (state.followers as UiState.Success<List<DummyEntity>>).data)
        }
    }
}

@Composable
fun DummyScreen(
    dummyList: List<DummyEntity>,
) {
    LazyColumn {
        items(dummyList.size) { index ->
            Text(
                text = dummyList[index].firstName,
            )
        }
    }
}
