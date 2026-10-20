package dev.brahmkshatriya.echo.desktop.ui.theme

import androidx.compose.material3.ColorScheme
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.graphics.Color

val EchoDarkColors = darkColorScheme(
    primary = Color(4284960932L),
    onPrimary = Color(0xFFFFFFFF),
    primaryContainer = Color(4283381643L),
    secondary = Color(4284636017L),
    background = Color(0xFF070913),
    onBackground = Color(0xFFFFFFFF),
    surface = Color(0xFF0E121B),
    onSurface = Color(0xFFFFFFFF),
    surfaceVariant = Color(0xFF1E2333),
    onSurfaceVariant = Color(0xFFCAC4D0)
)

val EchoLightColors = EchoDarkColors

@Composable
fun EchoTheme(
    darkTheme: Boolean = true,
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = EchoDarkColors
    ) {
        CompositionLocalProvider(
            LocalContentColor provides Color.White
        ) {
            content()
        }
    }
}
