package org.sopt.and4ever.presentation.otherping

import android.util.Log
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
fun OtherPingListItem(
    content: String,
    timeString: String
){
    val splitedTimeString = timeString.split(" ")
    Log.d("fffff", splitedTimeString.toString())
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
                    text = splitedTimeString[0] + "." + splitedTimeString[1],
                    color = G06,
                    style = Body01
                )

                Spacer(modifier = Modifier.width(7.dp))

                Text(
                    text = splitedTimeString[3] + " " + if(splitedTimeString[4]=="오전") "AM" else "PM",
                    color = G06,
                    style = Body01
                )
            }

            Spacer(modifier = Modifier.height(6.dp))

            Text(
                text = content,
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
    OtherPingListItem("","")
}