package org.sopt.and4ever.presentation.mypingdetail

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun MyPingDetailScreen(
    modifier: Modifier = Modifier,
    viewModel: MyPingDetailViewModel = viewModel()
) {
    Text(text = "MyPingDetailScreen")
}