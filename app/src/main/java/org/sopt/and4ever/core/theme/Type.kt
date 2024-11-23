package org.sopt.and4ever.core.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import org.sopt.and4ever.R


val pretendardFontFamily = FontFamily(
    Font(resId = R.font.pretendard_bold, weight = FontWeight.Bold),
    Font(resId = R.font.pretendard_regular, weight = FontWeight.Normal)
)

internal val Typography = JPTypography(
    head06 = TextStyle(
        fontFamily = pretendardFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 20.sp,
        lineHeight = TextUnit.Unspecified,
        letterSpacing = 0.sp
    ),
    head05 = TextStyle(
        fontFamily = pretendardFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 18.sp,
        lineHeight = TextUnit.Unspecified,
        letterSpacing = 0.sp
    ),
    head04 = TextStyle(
        fontFamily = pretendardFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 16.sp,
        lineHeight = TextUnit.Unspecified,
        letterSpacing = 0.sp
    ),
    head03 = TextStyle(
        fontFamily = pretendardFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 14.sp,
        lineHeight = TextUnit.Unspecified,
        letterSpacing = 0.sp
    ),
    head02 = TextStyle(
        fontFamily = pretendardFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 12.sp,
        lineHeight = TextUnit.Unspecified,
        letterSpacing = 0.sp
    ),
    head01 = TextStyle(
        fontFamily = pretendardFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 10.sp,
        lineHeight = TextUnit.Unspecified,
        letterSpacing = 0.sp
    ),
    body04 = TextStyle(
        fontFamily = pretendardFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 15.sp,
        lineHeight = TextUnit.Unspecified,
        letterSpacing = 0.sp
    ),
    body03 = TextStyle(
        fontFamily = pretendardFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        lineHeight = TextUnit.Unspecified,
        letterSpacing = 0.sp
    ),
    body02 = TextStyle(
        fontFamily = pretendardFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp,
        lineHeight = TextUnit.Unspecified,
        letterSpacing = 0.sp
    ),
    body01 = TextStyle(
        fontFamily = pretendardFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 10.sp,
        lineHeight = TextUnit.Unspecified,
        letterSpacing = 0.sp
    )
)

@Immutable
data class JPTypography(
    val head06: TextStyle,
    val head05: TextStyle,
    val head04: TextStyle,
    val head03: TextStyle,
    val head02: TextStyle,
    val head01: TextStyle,
    val body04: TextStyle,
    val body03: TextStyle,
    val body02: TextStyle,
    val body01: TextStyle
)

val LocalJPTypography = staticCompositionLocalOf {
    JPTypography(
        head06 = TextStyle.Default,
        head05 = TextStyle.Default,
        head04 = TextStyle.Default,
        head03 = TextStyle.Default,
        head02 = TextStyle.Default,
        head01 = TextStyle.Default,
        body04 = TextStyle.Default,
        body03 = TextStyle.Default,
        body02 = TextStyle.Default,
        body01 = TextStyle.Default
    )
}