package org.sopt.and4ever.presentation.input.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.and4ever.R
import org.sopt.and4ever.core.theme.Body02
import org.sopt.and4ever.core.theme.G08
import org.sopt.and4ever.core.theme.Head02
import org.sopt.and4ever.core.theme.Head04


@Composable
fun InputTop(
    step: String,
    topMessage: String
) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 36.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        IconStep(step)

        Spacer(modifier = Modifier.padding(14.dp))

        Text(
            text = topMessage,
            color = Color.Black,
            style = Head04
        )

    }
}

@Composable
fun IconStep(step:String) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(20.dp)    // 요소 사이 간격 20.dp
    ) {
        Image(
            imageVector = ImageVector.vectorResource(id = R.drawable.img_eyes),
            contentDescription = "Step Icon"
        )
        Surface(
            modifier = Modifier.wrapContentSize(),
            color = Color(0xFFFFF1F3),
            shape = RoundedCornerShape(100.dp),
            shadowElevation = 0.dp
        ) {
            Box(
                modifier = Modifier.padding(horizontal = 10.dp, vertical = 4.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Step $step",
                    style = Head02,
                    color = G08
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun IconStepPrev() {
    InputTop(step = "1", topMessage = "어떤 상황을 피하고 싶으신가요?")


}
