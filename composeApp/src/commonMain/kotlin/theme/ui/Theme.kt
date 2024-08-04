package theme.ui

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Shapes
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

@Composable
fun AppTheme(content: @Composable () -> Unit) {
    val darkColors = darkColors(
        primary = primaryDark,
        primaryVariant = primaryContainerDark,
        secondary = secondaryDark
    )

    val lightColors = lightColors(
        primary = primaryLight,
        primaryVariant = primaryContainerLight,
        secondary = secondaryLight
    )

    MaterialTheme(
        colors = if (isSystemInDarkTheme()) darkColors else lightColors,
        content = content
    )
}