package org.sopt.and4ever.presentation.otherping

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import org.sopt.and4ever.core.theme.Black
import org.sopt.and4ever.core.theme.Body03
import org.sopt.and4ever.core.theme.G06
import org.sopt.and4ever.core.theme.Head06
import org.sopt.and4ever.data.service.MyPingService
import org.sopt.and4ever.data.service.OtherPingService
import org.sopt.and4ever.presentation.myping.formatDateTime

@Composable
fun OtherPingScreen(
    otherPingService: OtherPingService,
    modifier: Modifier = Modifier,
    viewModel: OtherPingViewModel = viewModel(
        factory = OtherPingViewModelFactory(otherPingService)
    ),
) {
    LaunchedEffect(Unit) {
        viewModel.getOtherPingList()
    }

    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    val isLoading by viewModel.isLoading.collectAsStateWithLifecycle()

    Column(
        modifier = modifier
            .padding(
                start = 20.dp,
                end = 20.dp,
                top = 41.dp
            )
    ) {
        Text(
            text = "오늘의 핑계는?",
            style = Head06,
            color = Black
        )

        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = "오늘 사람들이 성공한 핑계들이에요!",
            style = Body03,
            color = G06
        )

        if (isLoading.not()) {
            Spacer(modifier = Modifier.height(36.dp))

            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                items(uiState.pingList) { myPing ->
                    val timeString = formatDateTime(myPing.createdDate)
                    OtherPingListItem(
                        content = myPing.ping,
                        timeString = timeString
                    )
                }
            }
        } else {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        }
    }
}
