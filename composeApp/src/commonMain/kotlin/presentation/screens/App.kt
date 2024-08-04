package presentation.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

import crunktimer.composeapp.generated.resources.Res
import crunktimer.composeapp.generated.resources.compose_multiplatform
import crunktimer.composeapp.generated.resources.crunk_logo_removebg_preview
import presentation.screens.setup.SetupScreen
import presentation.screens.splash.SplashScreen
import theme.ui.AppTheme

sealed class Screen(val route: String) {
    data object Splash : Screen("splash")
    data object Setup : Screen("setup")
}

@Composable
@Preview
fun App(
    navController: NavHostController = rememberNavController()
) {
    AppTheme {
        Scaffold {
            NavHost(
                navController = navController,
                startDestination = Screen.Splash.route,
                modifier = Modifier.fillMaxSize()
            ) {
                composable(route = Screen.Splash.route) {
                    SplashScreen(
                        onProceedToNextScreen = {
                            navController.navigate(Screen.Setup.route)
                        }
                    )
                }
                composable(route = Screen.Setup.route) {
                    SetupScreen()
                }
            }
        }
    }
}