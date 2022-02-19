package com.mahmoudrh.bahgatresturant

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.mahmoudrh.bahgatresturant.ui.*


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
                navHostController.navigate("ResetPasswordScreen")

            }, navigateToSignUpScreen = {
                navHostController.navigate("SignUpScreen"){
                    popUpTo("WelcomeScreen")
                }

            })
        }

        composable("SignUpScreen"){
            SignUpScreen {
             navHostController.navigate("SignInScreen"){
                 popUpTo("WelcomeScreen")
             }
            }
        }

        composable("ResetPasswordScreen"){
            ResetPasswordScreen {
                navHostController.navigate("EmailVerificationScreen")
            }
        }

        composable("EmailVerificationScreen"){
            EmailVerificationScreen {
                navHostController.navigate("ChangePasswordScreen")
            }
        }

        composable("ChangePasswordScreen"){
            ChangePasswordScreen()
        }
    }
}