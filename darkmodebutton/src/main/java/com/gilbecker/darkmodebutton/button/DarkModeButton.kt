package com.gilbecker.darkmodebutton.button

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import com.gilbecker.darkmodebutton.R
import com.gilbecker.darkmodebutton.transition.updateMoonTransitionData
import com.gilbecker.darkmodebutton.transition.updateSunTransitionData

private val DEFAULT_SUN_COLOR = Color(0XFFFFDC00)
private val DEFAULT_MOON_COLOR = Color(0XFFDDDDDD)

@Composable
fun DarkModeButton(
    modifier: Modifier = Modifier,
    sunColor: Color = DEFAULT_SUN_COLOR,
    moonColor: Color = DEFAULT_MOON_COLOR,
    isSystemInDarkMode: MutableState<Boolean>
) {
    val interactionSource = remember { MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsState()
    var isDarkMode by isSystemInDarkMode

    Box(
        modifier = modifier
            .scale(if (isPressed) 0.85f else 1f)
            .background(Color.Transparent, CircleShape)
            .clickable(
                interactionSource = interactionSource,
                indication = null
            ) {
                isDarkMode = !isDarkMode
            },
        contentAlignment = Alignment.Center
    )
    {
        val transitionDataMoon =
            updateMoonTransitionData(isDarkMode, moonColor, sunColor)
        val transitionDataSun =
            updateSunTransitionData(isDarkMode, moonColor, sunColor)

        Image(
            painter = painterResource(R.drawable.moon),
            contentDescription = "moon",
            modifier = modifier
                .scale(transitionDataMoon.scale)
                .alpha(transitionDataMoon.alpha)
                .rotate(transitionDataMoon.angle),
            colorFilter = ColorFilter.tint(if (isPressed) sunColor else transitionDataMoon.color)
        )

        Image(
            painter = painterResource(R.drawable.sun),
            "sun",
            modifier = modifier
                .scale(transitionDataSun.scale)
                .alpha(transitionDataSun.alpha)
                .rotate(transitionDataMoon.angle),
            colorFilter = ColorFilter.tint(if (isPressed) moonColor else transitionDataSun.color)
        )
    }
}
