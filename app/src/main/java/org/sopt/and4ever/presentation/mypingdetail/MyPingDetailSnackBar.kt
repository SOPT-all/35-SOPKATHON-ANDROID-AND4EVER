package org.sopt.and4ever.presentation.mypingdetail

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.and4ever.R
import org.sopt.and4ever.core.theme.G07
import org.sopt.and4ever.core.theme.Head06

@Composable
fun MyPingDetailSnackBar(){
    Box(
        modifier = Modifier
            .border(
                width = 6.dp,
                color = Color(0xFFFF4A63),
                shape = RoundedCornerShape(12.dp)
            ).fillMaxWidth()
            .background(
                color = Color.White,
                shape = RoundedCornerShape(12.dp)
            )
            .padding(vertical = 15.dp),
        contentAlignment = Alignment.Center
    ){
        Row(
            horizontalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(R.drawable.img_eyes),
                contentDescription = ""
            )

            Spacer(modifier = Modifier.width(18.dp))

            Text(
                text = "완벽한 ",
                color = Color(0xFFFF4A63),
                style = Head06
            )
            Text(
                text = "핑계였군요!",
                color = G07,
                style = Head06
            )
        }
    }
}

@Preview
@Composable
fun MyPingDetailSnackBarPreview(){
    MyPingDetailSnackBar()
}