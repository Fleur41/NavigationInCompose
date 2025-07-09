package com.sam.navigationincompose.navigation


import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navDeepLink
import com.sam.navigationincompose.navigation.detail.DetailScreen
import com.sam.navigationincompose.navigation.home.HomeScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = NavDestination.Home.name
    ){
        composable(
            route = NavDestination.Home.name
        ){
            HomeScreen(onDetailClick = {text ->
                val route = buildString {
                    append(NavDestination.Detail.name)
                    if(text.isNotBlank()){
                        append("?username=$text")
                    }
                }
                navController.navigate(route)
            })
        }
        composable(
//            route = NavDestination.Detail.name + "/{username}",
            route = NavDestination.Detail.name + "?username={username}",
            arguments = listOf(
                navArgument("username"){
                    type = NavType.StringType
                    defaultValue = "sammir"
                },
            )
        ){ backStackEntry ->
            val username = backStackEntry.arguments?.getString("username") ?: return@composable
            DetailScreen(
                username = username,
                onBackClick = {navController.popBackStack()}
            )
        }
    }
}
