package org.sopt.and4ever.presentation.result.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import org.sopt.and4ever.R
import org.sopt.and4ever.core.theme.Body04

@Composable
fun WhiteTextBox(
    input: String,
    onCopyClick: () -> Unit = {}
) {
    Box(
        modifier = Modifier.fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.img_white_speech_bubble),
            contentDescription = "흰색 말풍선 배경",
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
        IconButton(
            onClick = onCopyClick,
            modifier = Modifier
                .align(Alignment.CenterEnd)
                .size(24.dp)
        ) {
            Image(
                imageVector = ImageVector.vectorResource(id = R.drawable.ic_copy), // 임시 아이콘
                contentDescription = "텍스트 복사하기"
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun WhiteTextBoxPreview() {
    WhiteTextBox(
        input = "ai가 생성한 핑계 텍스트 더미 ai가 생성한 핑계 텍스트 더미 ai가 생성한 핑계 텍스트 더미 ai가 생성한 핑계 텍스트 더미"
    )
}
