package com.example.hutsysreens.Naviagation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.hutsysreens.Presentation.ForgotPassword.forgotPasswordScreen_Otp
import com.example.hutsysreens.Presentation.Login.loginScreen
import com.example.hutsysreens.Presentation.NewPassword.newPasswordScreen
import com.example.hutsysreens.Presentation.Register.RegisterScreen
import com.example.hutsysreens.Presentation.VerificationScreen.VerificationScreen

sealed class Route {
    data class loginScreen(val name: String = "login") : Route()
    data class registerScreen(val name: String = "register") : Route()
    data class forgotPasswordScreen(val name: String = "forgetPassword") : Route()
    data class verificationScreen(val name: String = "verification") : Route()
    data class newPasswordScreen(val name: String = "newPassword") : Route()
}

@Composable
fun myNavs(
    navHostController: NavHostController
) {
    NavHost(
        navController = navHostController,
        startDestination = Route.loginScreen().name,
    ) {
        composable(route = Route.loginScreen().name) {
            loginScreen(
                onLoginClick = {},
                onForgetPasswordClick = {
                    navHostController.navigate(
                        Route.forgotPasswordScreen().name
                    )
                },
                onSignUpButtonClick = {
                    navHostController.navigate(
                        Route.registerScreen().name
                    )
                })
        }
        composable(route = Route.registerScreen().name) {
            RegisterScreen(
                onButtonClick = {
                    navHostController.navigate(
                        Route.loginScreen().name
                    )
                },
                onBackButtonClick = {

                    navHostController.navigateUp()
                }
            )
        }
        composable(route = Route.forgotPasswordScreen().name) {
            forgotPasswordScreen_Otp(modifier = Modifier,
                onClick = {
                    navHostController.navigate(
                        Route.verificationScreen().name
                    )
                },
                onBackButtonClicl = {
                    navHostController.navigateUp()
                })
        }
        composable(route = Route.verificationScreen().name) {
            VerificationScreen(
                modifier = Modifier,
                onClick = {
                    navHostController.navigate(
                        Route.newPasswordScreen().name
                    )
                },
                onBackButtonClicl = {
                    navHostController.navigateUp()
                }
            )
        }
        composable(route = Route.newPasswordScreen().name) {
            newPasswordScreen(
                modifier = Modifier,
                onClick = {
                    navHostController.navigate(
                        Route.loginScreen().name
                    )
                },
                onBackButtonClicl = {
                    navHostController.navigateUp()
                }
            )
        }

    }

}