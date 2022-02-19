package com.mahmoudrh.bahgatresturant

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.mahmoudrh.bahgatresturant.ui.SignInScreen
import com.mahmoudrh.bahgatresturant.ui.WelcomeScreen

@Composable
fun MyNavHost(navHostController: NavHostController) {
    NavHost(navController = navHostController, startDestination = "WelcomeScreen") {
        composable("WelcomeScreen") {
            WelcomeScreen(
                navigateToSignIn = {
                    navHostController.navigate("SignInScreen")
                }, navigateToSignUp = {
                    navHostController.navigate("SignUpScreen")
                })
        }

        composable("SignInScreen") {
            SignInScreen(navigateToResetPasswordScreen = {

            }, navigateToSignUpScreen = {

            })
        }

    }
}