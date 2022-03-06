package com.mahmoudrh.bahgatresturant

import android.os.Build
import android.util.Log
import androidx.compose.animation.*
import androidx.compose.animation.core.tween
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import com.mahmoudrh.bahgatresturant.ui.weclome.*
import com.mahmoudrh.bahgatresturant.ui.authentication.*
import com.mahmoudrh.bahgatresturant.ui.home.*

private enum class ROUTES {
    SPLASH_SCREEN,
    PAGE_VIEW_SCREEN,
    WELCOME_SCREEN,
    SIGN_IN_SCREEN,
    SIGN_UP_SCREEN,
    RESET_PASSWORD_SCREEN,
    EMAIL_VERIFICATION_SCREEN,
    CHANGE_PASSWORD_SCREEN,
    HOME_SCREEN,
}

@ExperimentalMaterialApi
@OptIn(ExperimentalAnimationApi::class)
@Composable
fun MyNavHost(navHostController: NavHostController) {
    AnimatedNavHost(
        navController = navHostController,
//        startDestination = setStartDestination()
        startDestination = ROUTES.RESET_PASSWORD_SCREEN.name
    ) {
        composable(
            route = ROUTES.SPLASH_SCREEN.name,
            exitTransition = {
                fadeOut(tween(400)) + slideOutVertically(
                    tween(400),
                    targetOffsetY = { -400 })
            }) {
            SplashScreen(
                navigateToPageView = {
                    navHostController.popBackStack()
                    navHostController.navigate(route = ROUTES.PAGE_VIEW_SCREEN.name)
                }
            )
        }

        composable(route = ROUTES.PAGE_VIEW_SCREEN.name,
            exitTransition = {
                slideOutHorizontally(
                    animationSpec = tween(300),
                    targetOffsetX = { -300 }) + fadeOut(
                    tween(300)
                )
            }) {
            PageViewScreen(
                navigateToWelcomeScreen = {
                    navHostController.popBackStack()
                    navHostController.navigate(route = ROUTES.WELCOME_SCREEN.name)
                }
            )
        }

        composable(route = ROUTES.WELCOME_SCREEN.name,
            enterTransition = {
                slideInHorizontally(animationSpec = tween(300), initialOffsetX = { 300 }) + fadeIn(
                    tween(300)
                )
            },
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
                    navHostController.navigate(route = ROUTES.SIGN_IN_SCREEN.name)
                },
                navigateToSignUp = {
                    navHostController.navigate(route = ROUTES.SIGN_UP_SCREEN.name)
                })
        }

        composable(route = ROUTES.SIGN_IN_SCREEN.name,
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
                navHostController.navigate(route = ROUTES.RESET_PASSWORD_SCREEN.name)

            }, navigateToSignUpScreen = {
                navHostController.navigate(route = ROUTES.SIGN_UP_SCREEN.name) {
                    popUpTo(route = ROUTES.WELCOME_SCREEN.name)
                }
            }, navigateToHomeScreen = {
                navHostController.navigate(route = ROUTES.HOME_SCREEN.name)
            })
        }

        composable(route = ROUTES.SIGN_UP_SCREEN.name) {
            SignUpScreen {
                navHostController.navigate(route = ROUTES.SIGN_IN_SCREEN.name) {
                    popUpTo(route = ROUTES.WELCOME_SCREEN.name)
                }
            }
        }

        composable(route = ROUTES.RESET_PASSWORD_SCREEN.name,
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
                navHostController.navigate(route = ROUTES.EMAIL_VERIFICATION_SCREEN.name)
            }
        }

        composable(route = ROUTES.EMAIL_VERIFICATION_SCREEN.name,
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
                navHostController.navigate(route = ROUTES.CHANGE_PASSWORD_SCREEN.name)
            }
        }

        composable(route = ROUTES.CHANGE_PASSWORD_SCREEN.name,
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

        composable(route = ROUTES.HOME_SCREEN.name) {
            HomeNavigation()
        }

        composable(route = "CheckoutScreen") {
            CheckoutScreen()
        }
    }
}

private fun setStartDestination(): String{

    return if (Build.VERSION.SDK_INT >= 31){
        ROUTES.PAGE_VIEW_SCREEN.name
    }else{
        ROUTES.SPLASH_SCREEN.name
    }
}

