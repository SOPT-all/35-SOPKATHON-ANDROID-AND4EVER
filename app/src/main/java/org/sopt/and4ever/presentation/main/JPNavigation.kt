package org.sopt.and4ever.presentation.main

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import org.sopt.and4ever.core.navigation.Route
import org.sopt.and4ever.presentation.home.HomeScreen
import org.sopt.and4ever.presentation.input.InputScreen

@Composable
fun JPNavigation(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController()
) {

    NavHost(
        navController = navController,
        startDestination = Route.Home
    ) {
        composable<Route.Home> {
            HomeScreen(
                modifier = Modifier.fillMaxWidth()
            )
        }

        composable<Route.Input> {
            InputScreen(
                modifier = Modifier.fillMaxWidth()
            )
        }

        composable<Route.Result> {

        }

        composable<Route.MyPing> {

        }

        composable<Route.MyPingDetail> {

        }
    }
}