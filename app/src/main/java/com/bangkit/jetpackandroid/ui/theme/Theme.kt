package com.bangkit.jetpackandroid.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorPalette = darkColors(
    primary = Color(0xFF6D4C41),
    primaryVariant = Color(0xFF4E342E),
    secondary = Color(0xFFA1887F),
    background = Color(0xFFA1887F),
    surface = Color(0xFFE0E0E0),
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black
)

private val LightColorPalette = darkColors(
    primary = Color(0xFF6D4C41),
    primaryVariant = Color(0xFF4E342E),
    secondary = Color(0xFFA1887F),
    background = Color(0xFFA1887F),
    surface = Color(0xFFE0E0E0),
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black
)

@Composable
fun JetpackandroidTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}