package org.sopt.and4ever.presentation.input.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.unit.dp
import org.sopt.and4ever.core.theme.Body03
import org.sopt.and4ever.core.theme.Head05

private const val MAX_CHARS = 200

@Composable
fun ExcuseInputScreen(
    modifier: Modifier = Modifier,
    onGenerateClick: (String) -> Unit = {}
) {
    var inputText by remember { mutableStateOf("") }

    Column(
        modifier = modifier
            .fillMaxWidth()
    ) {
        CustomTextField(
            value = inputText,
            onValueChange = { newText ->
                if (newText.length <= MAX_CHARS) {
                    inputText = newText
                }
            }
        )

        Spacer(modifier = Modifier.height(28.dp))

        Button(
            onClick = { onGenerateClick(inputText) },
            modifier = Modifier
                .fillMaxWidth()
                .height(54.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = if (inputText.isNotEmpty()) Color(0xFFFF4A63) else Color(0xFFC1C1C1)
            ),
            shape = RoundedCornerShape(12.dp),
            enabled = inputText.isNotEmpty()
        ) {
            Text(
                text = "핑계 생성하기",
                color = Color.White,
                style = Head05
            )
        }
    }
}

@Composable
private fun CustomTextField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    placeholder: String = "즐기기 힘든 상황을, 피하고 싶은 상황을 작성해주세요."
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(420.dp)
            .border(
                width = 1.dp,
                color = if (value.isNotEmpty()) Color(0xFFFFADB8) else Color(0xFFDFDFDF),
                shape = RoundedCornerShape(12.dp)
            )
    ) {
        BasicTextField(
            value = value,
            onValueChange = onValueChange,
            modifier = Modifier
                .fillMaxSize()
                .padding(vertical = 24.dp, horizontal = 30.dp),
            decorationBox = { innerTextField ->
                Box(
                    modifier = Modifier.fillMaxSize()
                ) {
                    if (value.isEmpty()) {
                        Text(
                            text = placeholder,
                            color = Color(0xFFC1C1C1),
                            style = Body03
                        )
                    }
                    innerTextField()
                }
            },
            textStyle = Body03,
            cursorBrush = SolidColor(Color(0xFFFFADB8))
        )
    }
}
