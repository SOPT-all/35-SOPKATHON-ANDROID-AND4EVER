package org.sopt.and4ever.presentation.result.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import org.sopt.and4ever.core.theme.Head05

@Composable
fun RefreshButton(
    onRefresh: () -> Unit
){
    Button(
        onClick = onRefresh,
        modifier = Modifier
            .fillMaxWidth()
            .height(54.dp),
        colors = ButtonDefaults.buttonColors(Color.White),
        border = BorderStroke(1.dp, Color(0xFFFF4A63)),
        shape = RoundedCornerShape(12.dp)
    ) {
        Text(
            text = "다른 핑계도 볼래요!",
            color = Color(0xFFFF4A63),
            style = Head05
        )
    }
}
