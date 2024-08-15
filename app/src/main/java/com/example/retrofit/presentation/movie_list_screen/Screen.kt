package com.example.retrofit.presentation.movie_list_screen

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.colorResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.retrofit.R
import com.example.retrofit.presentation.main_screen.items.BottomAppBar
import com.example.retrofit.presentation.movie_list_screen.items.Content
import com.example.retrofit.presentation.movie_list_screen.items.TopBar

@Composable
fun Screen(
    viewModel: ScreenViewModel = hiltViewModel(),
    navController: NavHostController
) {

    val background = colorResource(id = R.color.offBlack)
    val list = viewModel.state.dataItems

    Scaffold(
        topBar = {
            TopBar(background,viewModel,navController)
        }, content = { paddingValues ->
            Content(list,navController,paddingValues,background,viewModel)
        },
        bottomBar = {
            BottomAppBar(navController)
        }
    )
}