import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.graphics.Color

private val Blue200 = Color(0xFF81d4fa)
private val Blue500 = Color(0xFF03a9f4)
private val Blue700 = Color(0xFF0288d1)

private val darkColorPalette = darkColors()

private val lightColorPalette = lightColors(
    primary = Blue500,
    primaryVariant = Blue700
)


@Composable
fun DarkButtonExampleTheme(darkTheme: State<Boolean>, content: @Composable () -> Unit) {
    val colors = if (darkTheme.value) {
        darkColorPalette
    } else {
        lightColorPalette
    }

    MaterialTheme(
        colors = colors,
        content = content
    )
}