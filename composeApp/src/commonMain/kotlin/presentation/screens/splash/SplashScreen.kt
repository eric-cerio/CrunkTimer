package presentation.screens.splash

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import crunktimer.composeapp.generated.resources.Res
import crunktimer.composeapp.generated.resources.compose_multiplatform
import crunktimer.composeapp.generated.resources.crunk_logo_removebg_preview
import kotlinx.coroutines.delay
import org.jetbrains.compose.resources.painterResource
import androidx.lifecycle.viewmodel.compose.viewModel as composeViewModel

@Composable
fun SplashScreen(
    viewModel: SplashScreenViewModel = composeViewModel { SplashScreenViewModel() },
    onProceedToNextScreen: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize().background(Color.Black),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val scale = remember {
            Animatable(0F)
        }

        LaunchedEffect(true) {
            scale.animateTo(
                targetValue = 0.7F,
                animationSpec = tween(
                    durationMillis = 500
                )
            )
            delay(1000L)
            onProceedToNextScreen()
        }
        Image(
            painter = painterResource(Res.drawable.crunk_logo_removebg_preview),
            contentDescription = null,
        )
    }
}