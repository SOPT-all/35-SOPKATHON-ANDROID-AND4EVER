package org.sopt.and4ever.presentation.myping

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun MyPingScreen(
    modifier: Modifier = Modifier,
    viewModel: MyPingViewModel = viewModel()
) {
    Text(text = "MyPingScreen")
}
