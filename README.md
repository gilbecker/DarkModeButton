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
    var value: Float by rememberSaveable { mutableStateOf(3.2f) }  //initial rating value is 3.2 here
    Column(){
       RatingBar(value = value){
                value=it
                Log.d("TAG", "onRatingChanged: $it")
            }
     }
```

Ratingbar composable function has 11 params with default value as shown below
```kotlin
fun RatingBar(
    modifier: Modifier = Modifier,
    value: Float = 0f,
    numStars: Int = 5, size: Dp = 26.dp, padding: Dp = 2.dp,
    isIndicator: Boolean = false, activeColor: Color = Color(0xffffd740),
    inactiveColor: Color = Color(0xffffecb3),
    stepSize: StepSize = StepSize.ONE, 
    ratingBarStyle: RatingBarStyle=RatingBarStyle.Normal,
    onRatingChanged: (Float) -> Unit
)
