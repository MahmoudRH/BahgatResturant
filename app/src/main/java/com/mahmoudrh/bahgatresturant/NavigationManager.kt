package com.mahmoudrh.bahgatresturant

import androidx.compose.animation.*
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import com.mahmoudrh.bahgatresturant.ui.*


@OptIn(ExperimentalAnimationApi::class)
@Composable
fun MyNavHost(navHostController: NavHostController) {
    AnimatedNavHost(navController = navHostController, startDestination = "SplashScreen") {
        composable("SplashScreen") {
            SplashScreen(
                navigateToPageView = {
                    navHostController.popBackStack()
                    navHostController.navigate("PageViewScreen")
                }
            )
        }

        composable("PageViewScreen") {
            PageViewScreen(
                navigateToWelcomeScreen = {
                    navHostController.popBackStack()
                    navHostController.navigate("WelcomeScreen")
                }
            )
        }

        composable(route = "WelcomeScreen",
            popEnterTransition = {
                slideInHorizontally(animationSpec = tween(300), initialOffsetX = { -300 }) + fadeIn(
                    tween(300)
                )
            },
            exitTransition = {
                slideOutHorizontally(
                    animationSpec = tween(300),
                    targetOffsetX = { -300 }) + fadeOut(
                    tween(300)
                )
            }) {
            WelcomeScreen(
                navigateToSignIn = {
                    navHostController.navigate("SignInScreen")
                },
                navigateToSignUp = {
                    navHostController.navigate("SignUpScreen")
                })
        }

        composable(route = "SignInScreen",
            popEnterTransition = {
                slideInHorizontally(animationSpec = tween(300), initialOffsetX = { -300 }) + fadeIn(
                    tween(300)
                )
            },
            enterTransition = {
                slideInHorizontally(animationSpec = tween(300), initialOffsetX = { 300 }) + fadeIn(
                    tween(300)
                )
            },
            exitTransition = {
                slideOutHorizontally(
                    animationSpec = tween(300),
                    targetOffsetX = { -300 }) + fadeOut(
                    tween(300)
                )
            },
            popExitTransition = {
                slideOutHorizontally(
                    animationSpec = tween(300),
                    targetOffsetX = { 300 }) + fadeOut(
                    tween(300)
                )
            }) {
            SignInScreen(navigateToResetPasswordScreen = {
                navHostController.navigate("ResetPasswordScreen")

            }, navigateToSignUpScreen = {
                navHostController.navigate("SignUpScreen") {
                    popUpTo("WelcomeScreen")
                }

            })
        }

        composable("SignUpScreen") {
            SignUpScreen {
                navHostController.navigate("SignInScreen") {
                    popUpTo("WelcomeScreen")
                }
            }
        }

        composable("ResetPasswordScreen",
            popEnterTransition = {
                slideInHorizontally(animationSpec = tween(300), initialOffsetX = { -300 }) + fadeIn(
                    tween(300)
                )
            },
            enterTransition = {
                slideInHorizontally(animationSpec = tween(300), initialOffsetX = { 300 }) + fadeIn(
                    tween(300)
                )
            },
            exitTransition = {
                slideOutHorizontally(
                    animationSpec = tween(300),
                    targetOffsetX = { -300 }) + fadeOut(
                    tween(300)
                )
            },
            popExitTransition = {
                slideOutHorizontally(
                    animationSpec = tween(300),
                    targetOffsetX = { 300 }) + fadeOut(
                    tween(300)
                )
            }) {
            ResetPasswordScreen {
                navHostController.navigate("EmailVerificationScreen")
            }
        }

        composable("EmailVerificationScreen",
            popEnterTransition = {
                slideInHorizontally(animationSpec = tween(300), initialOffsetX = { -300 }) + fadeIn(
                    tween(300)
                )
            },
            enterTransition = {
                slideInHorizontally(animationSpec = tween(300), initialOffsetX = { 300 }) + fadeIn(
                    tween(300)
                )
            },
            exitTransition = {
                slideOutHorizontally(
                    animationSpec = tween(300),
                    targetOffsetX = { -300 }) + fadeOut(
                    tween(300)
                )
            },
            popExitTransition = {
                slideOutHorizontally(
                    animationSpec = tween(300),
                    targetOffsetX = { 300 }) + fadeOut(
                    tween(300)
                )
            }) {
            EmailVerificationScreen {
                navHostController.navigate("ChangePasswordScreen")
            }
        }

        composable("ChangePasswordScreen",
            enterTransition = {
                slideInHorizontally(animationSpec = tween(300), initialOffsetX = { 300 }) + fadeIn(
                    tween(300)
                )
            },
            popExitTransition = {
                slideOutHorizontally(
                    animationSpec = tween(300),
                    targetOffsetX = { 300 }) + fadeOut(
                    tween(300)
                )
            }) {
            ChangePasswordScreen()
        }
    }
}