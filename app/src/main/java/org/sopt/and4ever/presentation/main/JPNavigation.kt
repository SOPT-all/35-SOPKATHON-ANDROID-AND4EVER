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
import org.sopt.and4ever.presentation.otherping.OtherPingScreen
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
                modifier = Modifier.fillMaxSize(),
                onNavigateToInputScreen = {
                    navController.navigate(Route.Input)
                },
            )
        }

        composable<Route.Input> {
            InputScreen(
                modifier = Modifier.fillMaxSize(),
                onNavigateToResultScreen = {
                    navController.navigate(Route.Result)
                }
            )
        }

        composable<Route.Result> {
            ResultScreen(
                modifier = Modifier.fillMaxSize(),
                onNavigateToMyPingScreen = {
                    navController.navigate(Route.MyPing)
                }
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

        composable<Route.OtherPing> {
            OtherPingScreen(
                modifier = Modifier.fillMaxSize()
            )
        }
    }
}