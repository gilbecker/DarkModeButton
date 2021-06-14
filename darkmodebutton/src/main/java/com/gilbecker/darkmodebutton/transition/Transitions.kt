package com.gilbecker.darkmodebutton.transition

import androidx.compose.ui.graphics.Color
import androidx.compose.animation.animateColor
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.tween
import androidx.compose.animation.core.updateTransition
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember

private const val ANIMATION_DURATION = 1600

@Composable
internal fun updateMoonTransitionData(
    isDarkTheme: Boolean,
    moonColor: Color,
    sunColor: Color
): TransitionData {
    return updateTransitionData(isDarkTheme = isDarkTheme, planet = Planet.MOON, moonColor, sunColor)
}

@Composable
internal fun updateSunTransitionData(
    isDarkTheme: Boolean,
    moonColor: Color,
    sunColor: Color
): TransitionData {
    return updateTransitionData(isDarkTheme = isDarkTheme, planet = Planet.SUN, moonColor, sunColor)
}

internal class TransitionData(
    scale: State<Float>,
    alpha: State<Float>,
    angle: State<Float>,
    color: State<Color>
) {
    val alpha by alpha
    val angle by angle
    val scale by scale
    val color by color
}

@Composable
private fun updateTransitionData(
    isDarkTheme: Boolean,
    planet: Planet,
    moonColor: Color,
    sunColor: Color
): TransitionData {
    val transition = updateTransition(isDarkTheme, label = "")

    val alpha = transition.animateFloat(label = "alpha", transitionSpec = {
        tween(ANIMATION_DURATION + 600)
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
        tween(ANIMATION_DURATION - 600)
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

    val color = transition.animateColor(label = "color", transitionSpec = {
        tween(ANIMATION_DURATION)
    }) { darkTheme ->
        if (darkTheme) moonColor else sunColor
    }

    return remember(transition) { TransitionData(scale, alpha, angle, color) }
}

private enum class Planet {
    SUN, MOON
}
