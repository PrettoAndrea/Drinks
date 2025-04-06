package com.example.cocktailapp.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.material3.* // Importa tutto correttamente da material3
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

// Definisci il tuo schema di colori
private val LightColorScheme = lightColorScheme(
    primary = Color(0xFF6200EE),
    onPrimary = Color.White,
    secondary = Color(0xFF03DAC6),
    onSecondary = Color.Black,
    surface = Color.White,
    onSurface = Color.Black
)


private val CustomTypography = Typography(

)

@Composable
fun CocktailAppTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = LightColorScheme,
        typography = CustomTypography, // Passa il CustomTypography qui
        content = content
    )
}
