package org.sopt.and4ever.core.theme

import android.app.Activity
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

object JPTheme {
    val colors: JPColors
        @Composable
        @ReadOnlyComposable
        get() = LocalJPColors.current

//    val typography: JPTypography
//        @Composable
//        @ReadOnlyComposable
//        get() = LocalJPTypography.current
}

@Composable
fun ProvideJPColorsAndTypography(
    colors: JPColors,
//    typography: JPTypography,
    content: @Composable () -> Unit,
) {
    CompositionLocalProvider(
        LocalJPColors provides colors,
//        LocalJPTypography provides typography,
        content = content,
    )
}

@Composable
fun JPTheme(content: @Composable () -> Unit) {
    ProvideJPColorsAndTypography(
        colors = defaultJPColors,
//        typography = defaultJPTypography
    ) {
        val view = LocalView.current
        if (!view.isInEditMode) {
            SideEffect {
                (view.context as Activity).window.run {
                    statusBarColor = White.toArgb()
                    WindowCompat.getInsetsController(this, view).isAppearanceLightStatusBars = true
                }
            }
        }
        MaterialTheme(
            content = content,
            colorScheme = MaterialTheme.colorScheme.copy(
                primary = Color.White,
                secondary = Color.White,
                surface = Color.White,

            )
        )
    }
}
