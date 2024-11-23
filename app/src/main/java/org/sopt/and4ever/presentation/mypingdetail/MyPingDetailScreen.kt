package org.sopt.and4ever.presentation.mypingdetail

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxColors
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.LocalLifecycleOwner
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import org.sopt.and4ever.R
import org.sopt.and4ever.core.theme.Body03
import org.sopt.and4ever.core.theme.Body04
import org.sopt.and4ever.core.theme.Head02
import org.sopt.and4ever.core.theme.Head03
import org.sopt.and4ever.core.theme.Head04
import org.sopt.and4ever.core.theme.Head05
import org.sopt.and4ever.core.theme.JPTheme
import org.sopt.and4ever.core.util.state.UiState
import org.sopt.and4ever.core.util.state.noRippleClickable
import org.sopt.and4ever.data.model.response.GetPingDetail
import org.sopt.and4ever.data.service.MyPingDetailService
import org.sopt.and4ever.presentation.myping.formatDateTime

@Composable
fun MyPingDetailScreen(
    myPingId: Int,
    myPingDetailService: MyPingDetailService,
    modifier: Modifier = Modifier,
    viewModel: MyPingDetailViewModel = viewModel(
        factory = MyPingDetailViewModelFactory(
            myPingDetailService
        )
    ),
    navigateToMyPing: () -> Unit,
    popUp: () -> Unit,
    snackbarState: SnackbarHostState,
    coroutineScope: CoroutineScope
) {
    val lifecycleOwner = LocalLifecycleOwner.current
    val context = LocalContext.current

    val myPingState by viewModel.myPingState.collectAsStateWithLifecycle()

    LaunchedEffect(true) {
        viewModel.getPingDetail(myPingId)
    }

    LaunchedEffect(viewModel.myPingDetailSideEffect, lifecycleOwner) {
        viewModel.myPingDetailSideEffect.flowWithLifecycle(lifecycle = lifecycleOwner.lifecycle)
            .collect { sideEffect ->
                when (sideEffect) {
                    is MyPingDetailSideEffect.ShowToast -> {
                        coroutineScope.launch{
                            snackbarState.showSnackbar(message = sideEffect.message)
                        }
                        navigateToMyPing()
                    }
                }
            }
    }

    when (myPingState.pingDetail) {
        is UiState.Success -> {
            ShowMyPingDetailScreen(
                myPingId = myPingId,
                myPingDetail = (myPingState.pingDetail as UiState.Success<GetPingDetail>).data,
                myPingState.pingStatus,
                modifier,
                viewModel,
                popUp
            )
        }

        else -> {}
    }
}

@Composable
fun ShowMyPingDetailScreen(
    myPingId: Int,
    myPingDetail: GetPingDetail,
    myPingStatus: String,
    modifier: Modifier,
    viewModel: MyPingDetailViewModel,
    popUp: () -> Unit = {},
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier,
    ) {
        Image(
            painter = painterResource(R.drawable.img_eyes),
            contentDescription = null,
            modifier = Modifier.padding(top = 36.dp)
        )

        Text(
            text = stringResource(R.string.myping_step_3),
            style = Head02,
            color = JPTheme.colors.g08,
            modifier = Modifier
                .padding(top = 20.dp, bottom = 14.dp)
                .clip(RoundedCornerShape(50.dp))
                .background(JPTheme.colors.g03)
                .padding(vertical = 4.dp, horizontal = 10.dp),
        )

        Text(
            text = stringResource(R.string.myping_detail_title),
            style = Head04,
            color = JPTheme.colors.black,
        )

        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp)
        ) {
            Spacer(
                modifier = Modifier.weight(1f)
            )
            val date = formatDateTime(myPingDetail.createdDate)
            Text(
                text = date,
                style = Body03,
                color = JPTheme.colors.g06,
            )

            Box(
                modifier = Modifier
                    .weight(1f),
                contentAlignment = Alignment.CenterEnd,
            ) {
                Text(
                    text = "삭제하기",
                    style = Body03,
                    color = JPTheme.colors.g06,
                    modifier = Modifier
                        .noRippleClickable {
                            println("ddd")
                            viewModel.deletePing(myPingId) {
                                popUp()
                            }
                        }.padding(end = 20.dp)
                )
            }
        }

        Spacer(modifier = Modifier.weight(1f))

        Box(
            modifier = Modifier
                .padding(bottom = 12.dp)
                .width(IntrinsicSize.Min)
        ) {
            Image(
                painter = painterResource(R.drawable.img_pink_speech_bubble),
                contentDescription = null,
            )
            Text(
                text = myPingDetail.situation,
                style = Body04,
                color = JPTheme.colors.g09,
                modifier = Modifier
                    .padding(top = 20.dp, bottom = 16.dp, start = 37.dp, end = 33.dp)
                    .matchParentSize()
            )
        }

        Box(
            modifier = Modifier
                .padding(bottom = 12.dp)
                .width(IntrinsicSize.Min)
        ) {
            Image(
                painter = painterResource(R.drawable.img_white_speech_bubble),
                contentDescription = null
            )
            Text(
                text = myPingDetail.ping,
                style = Body04,
                color = JPTheme.colors.g09,
                modifier = Modifier
                    .padding(top = 20.dp, bottom = 16.dp, start = 33.dp, end = 37.dp)
                    .matchParentSize()
            )
        }

        Spacer(modifier = Modifier.weight(1f))

        Row {
            checkBox(
                isSuccess = myPingStatus,
                type = "fail",
                onClicked = { viewModel.updatePingStatus("fail") },
                text = "오늘은 실패 ㅜㅜ",
            )
            Spacer(modifier = Modifier.size(30.dp))
            checkBox(
                isSuccess = myPingStatus,
                type = "success",
                onClicked = { viewModel.updatePingStatus("success") },
                text = "내가 해냈음!",
            )
        }

        TextButton(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
                .padding(top = 30.dp),
            shape = RoundedCornerShape(12.dp),
            colors = ButtonColors(
                containerColor = Color(0xFFFF4A63),
                contentColor = Color(0xFFFF4A63),
                disabledContainerColor = Color(0xFFFF4A63),
                disabledContentColor = Color(0xFFFF4A63)
            ),
            contentPadding = PaddingValues(vertical = 16.dp),
            onClick = {
                viewModel.patchPingStatus(myPingId, pingStatus = myPingStatus)
            },
        ) {
            Text(
                text = "완료하기",
                style = Head05,
                color = JPTheme.colors.white,
            )
        }
    }
}


@Composable
fun checkBox(
    isSuccess: String,
    type: String,
    onClicked: () -> Unit,
    text: String,
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Checkbox(
            checked = isSuccess == type,
            onCheckedChange = { onClicked() },
            modifier = Modifier
                .size(24.dp),
            colors = CheckboxColors(
                checkedCheckmarkColor = Color(0x00),
                uncheckedCheckmarkColor = Color(0x00),
                checkedBoxColor = Color(0xFFFF4A63),
                uncheckedBoxColor = Color(0x00),
                disabledCheckedBoxColor = Color(0xFFFF4A63),
                disabledUncheckedBoxColor = Color(0x00),
                disabledIndeterminateBoxColor = Color(0x00),
                checkedBorderColor = Color(0xFFFF4A63),
                uncheckedBorderColor = JPTheme.colors.g07,
                disabledBorderColor = Color(0xFFFF4A63),
                disabledUncheckedBorderColor = JPTheme.colors.g07,
                disabledIndeterminateBorderColor = Color(0x00),
            ),
        )
        Text(
            text = text,
            style = Head03,
            color = JPTheme.colors.g07,
            modifier = Modifier
                .padding(start = 9.dp)
        )
    }
}