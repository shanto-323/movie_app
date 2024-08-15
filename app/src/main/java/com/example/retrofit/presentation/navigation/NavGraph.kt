package com.example.retrofit.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.retrofit.utils.Constants
import com.example.retrofit.presentation.movie_list_screen.Screen
import com.example.retrofit.presentation.detail_screen.DetailItemScreen
import com.example.retrofit.presentation.search_screen.Search
import com.example.retrofit.presentation.main_screen.Slide

@Composable
fun NavGraph(
    navController: NavHostController,
) {
    NavHost(
        navController = navController,
        startDestination = Constants.MAIN_SCREEN
    ){
        composable(Constants.SCREEN) {
            Screen(
                navController = navController
            )
        }
        composable(Constants.MAIN_SCREEN) {
            Slide(
                navController = navController
            )
        }
        composable(Constants.SEARCH_SCREEN) {
            Search(
                navController = navController
            )
        }

        composable(
            route = Constants.DETAIL_ITEM_SCREEN,
            arguments = listOf(navArgument(Constants.ITEM_INDEX) {
                type = NavType.IntType
            })
        ) {
            val itemIndex = it.arguments?.getInt(Constants.ITEM_INDEX)
            DetailItemScreen(
                movieId = itemIndex!!,
                navController = navController
            )
        }
    }
}

