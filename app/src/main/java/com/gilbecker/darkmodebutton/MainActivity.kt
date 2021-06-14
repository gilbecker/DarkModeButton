package com.gilbecker.darkmodebutton

import DarkButtonExampleTheme
import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gilbecker.darkmodebutton.button.DarkModeButton

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        val darkThemeState = getDarkThemeSystemState() // similar option using extension

        setContent {
            val darkThemeState = mutableStateOf(isSystemInDarkTheme())

            DarkButtonExampleTheme(darkTheme = darkThemeState) {
                Surface(color = MaterialTheme.colors.background) {

                    TopAppBar {
                        Row(
                            modifier = Modifier
                                .padding(4.dp)
                                .fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(text = "DarkThemeButton Example")
                            DarkModeButton(
                                modifier = Modifier
                                    .fillMaxHeight()
                                    .fillMaxHeight()
                                    .padding(2.dp),
                                isSystemInDarkMode = darkThemeState
                            )
                        }
                    }


                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .fillMaxHeight(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        DarkModeButton(
                            isSystemInDarkMode = darkThemeState,
                            modifier = Modifier.size(50.dp)
                        )
                    }
                }
            }
        }
    }
}

@SuppressLint("UnrememberedMutableState")
@ExperimentalAnimationApi
@Composable
@Preview
fun DefaultPreview() {
    val darkThemeState = mutableStateOf(isSystemInDarkTheme())

    DarkButtonExampleTheme(darkTheme = darkThemeState) {
        Surface(color = MaterialTheme.colors.background) {

            TopAppBar {
                Row(
                    modifier = Modifier
                        .padding(4.dp)
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "DarkThemeButton Example"
                    )
                    DarkModeButton(
                        modifier = Modifier
                            .padding(2.dp),
                        isSystemInDarkMode = darkThemeState
                    )
                }
            }


            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                DarkModeButton(
                    isSystemInDarkMode = darkThemeState,
                    modifier = Modifier.size(50.dp)
                )
            }
        }
    }
}