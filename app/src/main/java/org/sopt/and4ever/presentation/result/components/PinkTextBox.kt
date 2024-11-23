package org.sopt.and4ever.presentation.result.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import org.sopt.and4ever.R
import org.sopt.and4ever.core.theme.Body04

@Composable
fun PinkTextBox(input: String){
    Box(
        modifier = Modifier.fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.img_pink_speech_bubble),
            contentDescription = "핑크색 말풍선 배경",
            modifier = Modifier
                .fillMaxWidth()
        )
        Text(
            modifier = Modifier
                .padding(horizontal = 34.dp, vertical = 16.dp),
            text = input,
            style = Body04,
            color = Color(0xFF171717)
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun PinkTextBoxPreview() {
    PinkTextBox(input = "ai가 생성한 핑계 텍스트 더미 ai가 생성한 핑계 텍스트 더미 ai가 생성한 핑계 텍스트 더미 ai가 생성한 핑계 텍스트 더미")
}
