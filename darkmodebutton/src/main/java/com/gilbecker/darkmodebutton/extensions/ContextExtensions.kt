package com.gilbecker.darkmodebutton.extensions

import android.content.Context
import android.content.res.Configuration
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf

/**
 * Extensions function to
 */
fun Context.getDarkThemeSystemState(): MutableState<Boolean> {
    val uiMode = resources.configuration.uiMode
    return mutableStateOf((uiMode and Configuration.UI_MODE_NIGHT_MASK) == Configuration.UI_MODE_NIGHT_YES)
}