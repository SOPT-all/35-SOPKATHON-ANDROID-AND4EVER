package org.sopt.and4ever.presentation.main

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import org.sopt.and4ever.core.navigation.Route
import org.sopt.and4ever.presentation.home.HomeScreen
import org.sopt.and4ever.presentation.input.InputScreen
import org.sopt.and4ever.presentation.myping.MyPingScreen
import org.sopt.and4ever.presentation.mypingdetail.MyPingDetailScreen
import org.sopt.and4ever.presentation.result.ResultScreen

@Composable
fun JPNavigation(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController()
) {

    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = Route.Home
    ) {
        composable<Route.Home> {
            HomeScreen(
                modifier = Modifier.fillMaxSize()
            )
        }

        composable<Route.Input> {
            InputScreen(
                modifier = Modifier.fillMaxSize()
            )
        }

        composable<Route.Result> {
            ResultScreen(
                modifier = Modifier.fillMaxSize()
            )
        }

        composable<Route.MyPing> {
            MyPingScreen(
                modifier = Modifier.fillMaxSize()
            )
        }

        composable<Route.MyPingDetail> {
            MyPingDetailScreen(
                modifier = Modifier.fillMaxSize()
            )
        }
    }
}