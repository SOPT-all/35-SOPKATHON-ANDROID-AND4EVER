package org.sopt.and4ever.core.theme

import androidx.compose.ui.graphics.Color
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf

// Black & White
val Black = Color(0xFF000000)
val White = Color(0xFFFFFFFF)

// Grayscale
val G09 = Color(0xFF171717)
val G08 = Color(0xFF242424)
val G07 = Color(0xFF3D3D3D)
val G06 = Color(0xFF6F6F6F)
val G05 = Color(0xFF8B8B8B)
val G04 = Color(0xFFC1C1C1)
val G03 = Color(0xFFDFDFDF)
val G02 = Color(0xFFECECEC)
val G01 = Color(0xFFFBFBFB)

// JP color scheme class
@Immutable
data class JPColors(
    val black: Color,
    val white: Color,
    val g09: Color,
    val g08: Color,
    val g07: Color,
    val g06: Color,
    val g05: Color,
    val g04: Color,
    val g03: Color,
    val g02: Color,
    val g01: Color
)

// Default color scheme
val defaultJPColors = JPColors(
    black = Black,
    white = White,
    g09 = G09,
    g08 = G08,
    g07 = G07,
    g06 = G06,
    g05 = G05,
    g04 = G04,
    g03 = G03,
    g02 = G02,
    g01 = G01
)

val LocalJPColors = staticCompositionLocalOf { defaultJPColors }
