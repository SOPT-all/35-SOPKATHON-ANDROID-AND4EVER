package org.sopt.and4ever.presentation.home

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import org.sopt.and4ever.core.component.JPLottieAnimation
import org.sopt.and4ever.core.theme.Body02
import org.sopt.and4ever.core.theme.Head04
import org.sopt.and4ever.core.theme.Head06
import org.sopt.and4ever.core.theme.JPTheme
import org.sopt.and4ever.core.util.NoRippleInteraction

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = viewModel(),
    onNavigateToInputScreen: () -> Unit = {},
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = "Jeul-Ping!",
            style = Head06,
            color = JPTheme.colors.black,
            modifier = Modifier
                .padding(top = 41.dp, start = 20.dp)
                .fillMaxWidth(),
        )
        Text(
            text = "즐길 수 없으면 피해라, 핑계 메이커 즐-핑!",
            style = Body02,
            color = JPTheme.colors.black,
            modifier = Modifier
                .padding(top = 9.dp, start = 20.dp)
                .fillMaxWidth(),
        )

        JPLottieAnimation(
            jsonString = "img_home_character_real.json",
            modifier = Modifier.padding(top = 24.dp)
        )

        TextButton(
            onClick = onNavigateToInputScreen,
            contentPadding = PaddingValues(horizontal = 61.dp, vertical = 18.dp),
            colors = ButtonColors(
                containerColor = JPTheme.colors.white,
                contentColor = Color(0xFFFF4A63),
                disabledContainerColor = JPTheme.colors.white,
                disabledContentColor = Color(0xFFFF4A63)
            ),
            shape = RoundedCornerShape(12.dp),
            border = BorderStroke(1.dp, color = Color(0xFFFF4A63)),
            interactionSource = NoRippleInteraction,
            modifier = Modifier
                .padding(horizontal = 80.dp),
            content = {
                Text(
                    text = "핑계만들기",
                    style = Head04,
                    color = Color(0xFFFF4A63)
                )
            }
        )
    }
}
