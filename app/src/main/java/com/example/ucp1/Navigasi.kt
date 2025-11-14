package com.example.ucp1

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.ucp1.view.FormPage
import com.example.ucp1.view.ProfilPage
import com.example.ucp1.view.LoginPage

enum class Navigasi {
    Login,
    Home,
    Form
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun App(
    navController: NavHostController = rememberNavController()
){
    Box {
        NavHost(
            navController = navController,
            startDestination = Navigasi.Login.name,
            modifier = Modifier.fillMaxSize()
        )
        {
            composable(route = Navigasi.Login.name) {
                LoginPage(
                    onStartButtonClick = { navController.navigate(Navigasi.Home.name) }
                )
            }
            composable(route = Navigasi.Home.name) {
                ProfilPage(
                    onLogoutButtonClick = { cancelAndBackToStart(navController) },
                    onFormButtonClick = { navController.navigate(Navigasi.Form.name) }
                )
            }
            composable(route = Navigasi.Form.name) {
                FormPage(
                    onHomeButtonClick = { backToHome(navController) }
                )
            }
        }
    }
}

private fun cancelAndBackToStart(
    navController: NavHostController
) {
    navController.popBackStack(Navigasi.Login.name, inclusive = false)
}

private fun backToHome(
    navController: NavHostController
) {
    navController.popBackStack(Navigasi.Home.name, inclusive = false)
}