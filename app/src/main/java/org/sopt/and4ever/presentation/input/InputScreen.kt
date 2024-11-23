package org.sopt.and4ever.presentation.input

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.and4ever.presentation.input.components.ExcuseInputScreen
import org.sopt.and4ever.presentation.input.components.InputTop

@Composable
fun InputScreen(
    modifier: Modifier = Modifier,
    onNavigateWithInput: (String) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(horizontal = 20.dp),
        verticalArrangement = Arrangement.spacedBy(22.dp)
    ) {
        InputTop(
            step = "1",
            topMessage = "어떤 상황을 피하고 싶으신가요?"
        )
        ExcuseInputScreen(
            onGenerateClick = { input ->
                onNavigateWithInput(input)
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun InputScreenPreview() {
    InputScreen(
        onNavigateWithInput = {}
    )
}

