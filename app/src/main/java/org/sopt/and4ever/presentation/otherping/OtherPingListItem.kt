package org.sopt.and4ever.presentation.otherping

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.and4ever.core.theme.Body01
import org.sopt.and4ever.core.theme.Body04
import org.sopt.and4ever.core.theme.G06
import org.sopt.and4ever.core.theme.G09

@Composable
fun OtherPingListItem(){
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                color = Color(0xFFFFEDEF),
                shape = RoundedCornerShape(12.dp)
            )
            .border(
                width = 1.dp,
                color = G06,
                shape = RoundedCornerShape(12.dp)
            )
            .padding(
                horizontal = 23.dp,
                vertical = 14.dp
            )
    ){
        Column(){
            Row {
                Text(
                    text = "2024.11.23.토",
                    color = G06,
                    style = Body01
                )

                Spacer(modifier = Modifier.width(7.dp))

                Text(
                    text = "11:05 AM",
                    color = G06,
                    style = Body01
                )
            }

            Spacer(modifier = Modifier.height(6.dp))

            Text(
                text = "ai가 생성한 핑계 텍스트 더미 ai가 생성한 핑계 텍스트 더미 ai가 생성한 텍스트 더...dddddddddddddddddddddddddddddddddddddddddddddd",
                color = G09,
                style = Body04,
                overflow = TextOverflow.Ellipsis,
                maxLines = 2
            )
        }
    }
}

@Preview
@Composable
fun OtherPingListItemPreview(){
    OtherPingListItem()
}