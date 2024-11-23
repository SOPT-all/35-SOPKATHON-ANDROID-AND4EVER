package org.sopt.and4ever.presentation.myping

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.sharp.KeyboardArrowRight
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import org.sopt.and4ever.R
import org.sopt.and4ever.core.theme.Body01
import org.sopt.and4ever.core.theme.Body03
import org.sopt.and4ever.core.theme.Body04
import org.sopt.and4ever.core.theme.G04
import org.sopt.and4ever.core.theme.G06
import org.sopt.and4ever.core.theme.G08
import org.sopt.and4ever.core.theme.G09
import org.sopt.and4ever.core.theme.Head01
import org.sopt.and4ever.core.theme.Head06
import org.sopt.and4ever.core.theme.White

@Composable
fun MyPingScreen(
    modifier: Modifier = Modifier,
    viewModel: MyPingViewModel = viewModel()
) {
    Column(
        modifier = modifier,
    ) {
        Text(
            text = "마이핑",
            style = Head06
        )
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                modifier = Modifier.padding(top = 10.dp),
                text = "지금까지 시은님이 만든 핑계들이에요",
                style = Body03,
                color = G06
            )
            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = "필터",
                color = G08
            )
            Icon(
                painter = painterResource(R.drawable.ic_sort),
                contentDescription = "정렬"
            )
        }

        LazyColumn(
            modifier = Modifier.fillMaxWidth().padding(top = 35.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(5) {
                MyPingItem(modifier = Modifier.fillMaxWidth())
            }
        }
    }
}


@Composable
private fun MyPingItem(
    modifier: Modifier = Modifier
) {

    Card(
        colors = CardDefaults.cardColors(
            containerColor = White
        ),
        shape = RoundedCornerShape(12.dp),
        border = BorderStroke(width = 1.dp, color = G06),
        modifier = modifier
    ) {
        Column(
            modifier = Modifier.padding(vertical = 14.dp, horizontal = 23.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "2024.11.23 토",
                    style = Body01,
                    color = G06
                )
                Text(
                    modifier = Modifier.padding(start = 7.dp),
                    text = "11:05 AM",
                    style = Body01,
                    color = G06
                )
                Spacer(modifier = Modifier.weight(1f))
                MyPingItemChip(
                    modifier = Modifier
                        .clip(
                            shape = RoundedCornerShape(50f)
                        )
                        .background(
                            color = Color(0xffFF4A63)
                        ), text = "성공"
                )
            }

            Row(
                modifier = Modifier.padding(top = 6.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    modifier = Modifier.weight(1f),
                    text = "ai가 생성한 핑계 텍스트 ai가 생성한" +
                            " 핑계 텍스트 ai가 생성한 핑계 텍스트 ai가" +
                            " 생성한 핑계 텍스트 ai가 생성한 핑계 텍스트" +
                            " ai가 생성한 핑계 텍스트 ai가 생성한 핑계 텍스트 ",
                    style = Body04,
                    color = G09,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
                Icon(
                    modifier = Modifier.padding(start = 20.dp),
                    imageVector = Icons.AutoMirrored.Sharp.KeyboardArrowRight,
                    contentDescription = null,
                    tint = G04
                )
            }
        }
    }
}

@Composable
private fun MyPingItemChip(
    text: String,
    modifier: Modifier = Modifier,
) {

    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {
        Text(
            modifier = Modifier.padding(vertical = 2.dp, horizontal = 8.dp),
            text = text,
            style = Head01,
            color = White
        )
    }
}

@Composable
@Preview
private fun MyPingItemPreview() {
    MyPingItem(
        modifier = Modifier.fillMaxWidth()
    )
}