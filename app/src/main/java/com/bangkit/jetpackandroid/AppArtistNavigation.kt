package com.bangkit.jetpackandroid

import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import androidx.navigation.navArgument
import com.bangkit.jetpackandroid.*
import com.bangkit.jetpackandroid.uiscreen.AboutMeScreen
import com.bangkit.jetpackandroid.uiscreen.DetailActivity
import com.bangkit.jetpackandroid.uiscreen.HomeActivity
import com.bangkit.jetpackandroid.uiscreen.getArtistById

@Composable
fun AppArtistNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ) {
        composable(Screen.Home.route) {
            HomeActivity(
                listArtist = listArtist,
                onArtistSelected = { artist ->
                    navController.navigate(Screen.Detail.createRoute(artist.id))
                },
                navigateToAbout = {
                    navController.navigate(Screen.About.route)
                }
            )
        }
        composable(
            route = Screen.Detail.route,
            arguments = listOf(navArgument(ID) {type = NavType.IntType}),
        ) {
            val id = it.arguments?.getInt(ID) ?: -1
            DetailActivity(
                id = id,
                navigateBack = {
                    navController.navigateUp()
                }
            )
        }
        composable(Screen.About.route) {
            AboutMeScreen{
                navController.navigateUp()
            }
        }
    }
}
