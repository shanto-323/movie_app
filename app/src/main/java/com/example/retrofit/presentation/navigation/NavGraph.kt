package com.example.retrofit.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.retrofit.core.Constants
import com.example.retrofit.presentation.movie_screen.Screen
import com.example.retrofit.presentation.movie_screen.items.helper_screen.movie_detail.DetailItemScreen

@Composable
fun NavGraph(
    navController: NavHostController,
) {
    NavHost(
        navController = navController,
        startDestination = Constants.SCREEN
    ){
        composable(Constants.SCREEN) {
            Screen(
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
                itemIndex = itemIndex!!
            )
        }
    }
}

