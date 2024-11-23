package org.sopt.and4ever.presentation.result

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun ResultScreen(
    modifier: Modifier = Modifier,
    viewModel: ResultViewModel = viewModel(),
    onNavigateToMyPingScreen: () -> Unit = {},
    onNavigateToOtherPingScreen: () -> Unit = {}
) {
    Text("ResultScreen")
}