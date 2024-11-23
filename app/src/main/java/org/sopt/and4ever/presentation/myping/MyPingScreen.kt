package org.sopt.and4ever.presentation.myping

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.sharp.KeyboardArrowRight
import androidx.compose.material.icons.sharp.KeyboardArrowDown
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.util.fastForEach
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import org.sopt.and4ever.R
import org.sopt.and4ever.core.theme.Body01
import org.sopt.and4ever.core.theme.Body03
import org.sopt.and4ever.core.theme.Body04
import org.sopt.and4ever.core.theme.G04
import org.sopt.and4ever.core.theme.G06
import org.sopt.and4ever.core.theme.G09
import org.sopt.and4ever.core.theme.Head01
import org.sopt.and4ever.core.theme.Head06
import org.sopt.and4ever.core.theme.White
import org.sopt.and4ever.core.util.state.noRippleClickable
import org.sopt.and4ever.data.service.MyPingService
import org.sopt.and4ever.domain.model.MyPing
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

enum class FilterDropDownType(
    val title: String
) {
    ALL("전체"), SUCCESS("성공"), FAIL("실패"), PENDING("미정")
}

@Composable
fun MyPingScreen(
    myPingService: MyPingService,
    modifier: Modifier = Modifier,
    viewModel: MyPingViewModel = viewModel(factory = MyPingViewModelFactory(myPingService)),
    onNavigateToMyPingDetail: (Int) -> Unit = {},
) {

    val myPingList by viewModel.myPings.collectAsStateWithLifecycle()
    val filterDropDownType by viewModel.pingFilter.collectAsStateWithLifecycle()

    var isDropDownExpanded by remember { mutableStateOf(false) }

    val isEmpty by remember { derivedStateOf { myPingList.isEmpty() } }

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

            if(isEmpty.not()) {
            Row(
                modifier = Modifier
                    .width(100.dp)
                    .height(IntrinsicSize.Min)
                    .border(
                        width = 1.dp,
                        shape = RoundedCornerShape(4.dp),
                        color = G06
                    )
                    .padding(vertical = 6.dp)
                    .noRippleClickable {
                        isDropDownExpanded = !isDropDownExpanded
                    }, verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    modifier = Modifier.padding(horizontal = 16.dp),
                    text = filterDropDownType.title,
                    style = Head01,
                    color = G09
                )
                Icon(
                    modifier = Modifier.padding(start = 14.dp),
                    imageVector = Icons.Sharp.KeyboardArrowDown,
                    contentDescription = null,
                    tint = G06
                )
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .noRippleClickable {
                            isDropDownExpanded = !isDropDownExpanded
                        }
                ) {

                    MaterialTheme(
                        colorScheme = MaterialTheme.colorScheme.copy(surface = Color.White),
                    ) {
                        DropdownMenu(
                            modifier = Modifier
                                .border(
                                    width = 1.dp,
                                    color = G06
                                )
                                .background(Color.White),
                            expanded = isDropDownExpanded,
                            onDismissRequest = { isDropDownExpanded = false }
                        ) {
                            FilterDropDownType.entries.fastForEach {
                                if (it != filterDropDownType) {
                                    DropdownMenuItem(
                                        modifier = Modifier.width(100.dp),
                                        onClick = {
                                            viewModel.setPingFilter(it)
                                            isDropDownExpanded = false
                                        }, text = {
                                            Text(
                                                modifier = Modifier.fillMaxWidth(),
                                                text = it.title,
                                                style = Head01,
                                                textAlign = TextAlign.Start
                                            )
                                        }
                                    )
                                }

                            }
                        }
                    }
                }
            }
            }
        }

        if (isEmpty.not()) {
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 35.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                items(myPingList) { myPing ->
                    MyPingItem(
                        myPing = myPing,
                        modifier = Modifier.fillMaxWidth(),
                        onNavigateToMyPingDetail = {
                            onNavigateToMyPingDetail(it)
                        }
                    )
                }
            }
        }

        if (isEmpty) {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Image(
                    painter = painterResource(R.drawable.img_emptypage),
                    contentDescription = null
                )
                Text(
                    modifier = Modifier.padding(top = 34.dp),
                    text = "아직 만든 핑계가 없어요 ㅜㅜ",
                    style = Body03,
                )
            }
        }
    }
}


@Composable
private fun MyPingItem(
    myPing: MyPing,
    modifier: Modifier = Modifier,
    onNavigateToMyPingDetail: (Int) -> Unit = {},
) {

    Card(
        onClick = {
            onNavigateToMyPingDetail(myPing.pingId)
        },
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
                    text = formatDateTime(myPing.createdDate),
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
                            color = when(myPing.pingStatus) {
                                "success" -> Color(0xFFFF4A63)
                                "fail" -> G06
                                else -> G04
                            }
                        ),
                    text = when (myPing.pingStatus) {
                        "success" -> "성공"
                        "fail" -> "실패"
                        else -> "미정"
                    }
                )
            }

            Row(
                modifier = Modifier.padding(top = 6.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    modifier = Modifier.weight(1f),
                    text = myPing.ping,
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
            color = Color.White
        )
    }
}

fun formatDateTime(input: String): String {
    val dateTime = LocalDateTime.parse(input, DateTimeFormatter.ISO_LOCAL_DATE_TIME)

    val formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd")
    val formattedDate = dateTime.format(formatter)

    val dayOfWeek = dateTime.dayOfWeek.getDisplayName(java.time.format.TextStyle.SHORT, java.util.Locale.KOREAN)
    val timeFormatter = DateTimeFormatter.ofPattern("hh:mm a")
    val formattedTime = dateTime.format(timeFormatter)

    return "$formattedDate $dayOfWeek  $formattedTime"
}
