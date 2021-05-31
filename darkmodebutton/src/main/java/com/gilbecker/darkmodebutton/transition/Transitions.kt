package com.gilbecker.darkmodebutton.transition

import androidx.compose.animation.animateColor
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.tween
import androidx.compose.animation.core.updateTransition
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color

private const val ANIMATION_DURATION = 1600

@Composable
internal fun updateMoonTransitionData(
    isDarkTheme: Boolean,
    moonColor: Color,
    sunColor: Color
): TransitionData {
    return updateTransitionData(isDarkTheme = isDarkTheme, planet = Planet.MOON, moonColor = moonColor, sunColor = sunColor)
}

@Composable
internal fun updateSunTransitionData(
    isDarkTheme: Boolean,
    moonColor: Color,
    sunColor: Color
): TransitionData {
    return updateTransitionData(isDarkTheme = isDarkTheme, planet = Planet.SUN, moonColor = moonColor, sunColor = sunColor)
}

internal class TransitionData(
    color: State<Color>,
    scale: State<Float>,
    alpha: State<Float>,
    angle: State<Float>
) {
    val color by color
    val alpha by alpha
    val angle by angle
    val scale by scale
}

@Composable
private fun updateTransitionData(
    isDarkTheme: Boolean,
    planet: Planet,
    moonColor: Color,
    sunColor: Color
): TransitionData {
    val transition = updateTransition(isDarkTheme, label = "")

    val color = transition.animateColor(label = "color", transitionSpec = {
        tween(1000)
    }) { darkTheme ->
        if (darkTheme) moonColor else sunColor
    }

    val alpha = transition.animateFloat(label = "alpha", transitionSpec = {
        tween(2000)
    }) { darkTheme ->
        when (planet) {
            Planet.SUN -> {
                if (darkTheme) 0f else 1f
            }
            Planet.MOON -> {
                if (darkTheme) 1f else 0f
            }
        }
    }

    val angle = transition.animateFloat(label = "angle", transitionSpec = {
        tween(ANIMATION_DURATION)
    }) { darkTheme ->
        when (darkTheme) {
            true -> 0f
            false -> if (darkTheme) 720f else 360f
        }
    }

    val scale = transition.animateFloat(label = "scale", transitionSpec = {
        tween(ANIMATION_DURATION)
    }) { darkTheme ->
        when (planet) {
            Planet.SUN -> {
                if (darkTheme) 0.85f else 1f
            }
            Planet.MOON -> {
                if (darkTheme) 1f else 0.75f
            }
        }
    }

    return remember (transition) { TransitionData(color, scale, alpha, angle) }
}

private enum class Planet {
    SUN, MOON
}
