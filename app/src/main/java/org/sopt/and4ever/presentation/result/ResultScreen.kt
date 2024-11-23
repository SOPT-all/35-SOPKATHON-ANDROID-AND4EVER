package org.sopt.and4ever.presentation.result

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import org.sopt.and4ever.data.service.PingService
import org.sopt.and4ever.presentation.input.components.InputTop
import org.sopt.and4ever.presentation.result.components.PinkTextBox
import org.sopt.and4ever.presentation.result.components.RefreshButton
import org.sopt.and4ever.presentation.result.components.SelectButton
import org.sopt.and4ever.presentation.result.components.WhiteTextBox

@Composable
fun ResultScreen(
    modifier: Modifier = Modifier,
    situation: String,
    pingService: PingService,
    viewModel: ResultViewModel = viewModel(factory = ResultModelFactory(pingService)),
    onNavigateToMyPingScreen: () -> Unit
) {
    val uiState by viewModel.uiState.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.generatePing(situation)
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 20.dp),
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        InputTop(
            step = "2",
            topMessage = "이런 핑계는 어떠신가요?"
        )

        PinkTextBox(input = situation)

        when (val state = uiState) {
            is ResultUiState.Success -> {
                WhiteTextBox(
                    input = state.ping,
                    onCopyClick = { /* 복사 기능 구현 */ }
                )

                Column(verticalArrangement = Arrangement.spacedBy(7.dp)) {
                    SelectButton(
                        onSelect = {
                            viewModel.selectPing()
                            onNavigateToMyPingScreen()
                        },
                        isLoading = false
                    )

                    RefreshButton(
                        onRefresh = { viewModel.refreshPing(situation) }
                    )
                }
            }
            is ResultUiState.Loading -> {
                CircularProgressIndicator(
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )
            }
            is ResultUiState.Error -> {
                Text(
                    text = state.message,
                    color = Color.Red,
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )
            }
            else -> {}
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ResultScreenContentPreview() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(horizontal = 20.dp),
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        InputTop(
            step = "2",
            topMessage = "이런 핑계는 어떠신가요?"
        )

        PinkTextBox(input = "점심 약속에 늦었어요")

        WhiteTextBox(
            input = "버스가 안 와서 늦었어요",
            onCopyClick = {}
        )

        Column(verticalArrangement = Arrangement.spacedBy(7.dp)) {
            SelectButton(
                onSelect = {},
                isLoading = false
            )

            RefreshButton(
                onRefresh = {}
            )
        }
    }
}
