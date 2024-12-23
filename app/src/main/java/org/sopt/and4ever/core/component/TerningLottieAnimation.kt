package org.sopt.and4ever.core.component

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.RectangleShape
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.rememberLottieComposition

@Composable
fun JPLottieAnimation(
    jsonString: String,
    modifier: Modifier = Modifier,
    iterations: Int = 1,
) {
    val lottieComposition by rememberLottieComposition(LottieCompositionSpec.Asset(jsonString))
    LottieAnimation(
        modifier = modifier.clip(RectangleShape),
        composition = lottieComposition,
        iterations = iterations,
        clipToCompositionBounds = false
    )
}