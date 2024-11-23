package org.sopt.and4ever.presentation.input

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun InputScreen(
    modifier: Modifier = Modifier,
    viewModel: InputViewModel = viewModel(),
    onNavigateToResultScreen: () -> Unit = {},
) {
    Text("InputScreen")
}