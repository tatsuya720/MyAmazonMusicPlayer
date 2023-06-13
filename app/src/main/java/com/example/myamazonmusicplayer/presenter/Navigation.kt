package com.example.myamazonmusicplayer.presenter

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myamazonmusicplayer.presenter.initialize.InitializeScreen
import com.example.myamazonmusicplayer.presenter.home.HomeScreen
import com.example.myamazonmusicplayer.presenter.login.LoginScreen

enum class NavDestinationConst(val route: String) {
    INITIALIZE("initialize"),
    LOGIN("login"),
    HOME("home"),
}

@Composable
fun AppNavHost(
    navController: NavHostController = rememberNavController(),
    startDestination:NavDestinationConst = NavDestinationConst.INITIALIZE,
) {
    NavHost(
        navController = navController,
        startDestination = startDestination.route
    ) {
        composable(NavDestinationConst.INITIALIZE.route) {
            InitializeScreen(navController = navController, viewModel = hiltViewModel())
        }
        composable(NavDestinationConst.LOGIN.route) {
            LoginScreen(
                navController = navController,
                viewModel = hiltViewModel(),
                onClickLogin = {
                    Log.d("test", "onClick")
                }
            )
        }
        composable(NavDestinationConst.HOME.route) {
            HomeScreen(
                navController = navController,
                viewModel = hiltViewModel()
            )
        }
    }
}