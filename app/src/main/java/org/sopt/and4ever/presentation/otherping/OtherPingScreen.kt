package org.sopt.and4ever.presentation.otherping

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun OtherPingScreen(
    modifier: Modifier = Modifier,
    viewModel: OtherPingViewModel = viewModel()
) {
    Text(text = "OtherPingScreen")
}