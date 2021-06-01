# DarkModeButton

[![License](https://img.shields.io/badge/license-Apache%202-4EB1BA.svg?style=flat-square)](https://www.apache.org/licenses/LICENSE-2.0.html)

**DarkModeButton** is a Jetpack Compose button to quickly toggle between dark and light theme in your Android app.

# Gradle Dependency

Add this in your root `build.gradle` file (**not** your module `build.gradle` file):

```gradle
allprojects {
	repositories {
		...
		maven { url "https://jitpack.io" }
	}
}
```

#### Dependency

Add this to your module's `build.gradle` file:

```gradle
dependencies {
	...
	compile 'com.github.jd-alexander:LikeButton:0.2.3'
	}
}
```

# Usage 
```kotlin
setContent {
    val darkThemeState = mutableStateOf(isSystemInDarkTheme())

    DarkButtonExampleTheme(darkTheme = darkThemeState) {
        Surface(color = MaterialTheme.colors.background) {

            TopAppBar {
                Row {
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
        }
    }
}
```

DarkThemeButton @Composable function has 4 parameters, where isSystemInDarkMode is the only mandatory param.
```kotlin
@Composable
fun DarkModeButton(
    modifier: Modifier = Modifier,
    sunColor: Color = DEFAULT_SUN_COLOR,
    moonColor: Color = DEFAULT_MOON_COLOR,
    isSystemInDarkMode: MutableState<Boolean>
)
