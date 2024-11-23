package org.sopt.and4ever.presentation.result.components

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
fun SelectButton(
    onSelect: () -> Unit,
    isLoading: Boolean = false
) {
    Button(
        onClick = onSelect,
        modifier = Modifier
            .fillMaxWidth()
            .height(54.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFFFF4A63)
        ),
        shape = RoundedCornerShape(12.dp),
        enabled = !isLoading
    ) {
        Text(
            text = "이 핑계로 말해볼래요!",
            color = Color.White,
            style = Head05
        )
    }
}
