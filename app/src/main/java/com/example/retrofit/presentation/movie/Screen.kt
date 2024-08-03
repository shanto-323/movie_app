package com.example.retrofit.presentation.movie

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.retrofit.R
import com.example.retrofit.presentation.movie.items.BottomAppBar
import com.example.retrofit.presentation.movie.items.Content
import com.example.retrofit.presentation.movie.items.FloatingAction
import com.example.retrofit.presentation.movie.items.TopBar

@Composable
fun Screen(
    viewModel: ScreenViewModel = hiltViewModel(),
    navController: NavHostController
) {
    val list = viewModel.state.dataItems
    val background = colorResource(id = R.color.offBlack)
    val lazyGridState = rememberLazyGridState()
    val reachEnd by remember {
        derivedStateOf {
            val layoutInfo = lazyGridState.layoutInfo
            val totalItems = layoutInfo.totalItemsCount
            val lastVisibleIndex = (layoutInfo.visibleItemsInfo.lastOrNull()?.index ?: 0) + 1
            lastVisibleIndex == totalItems
        }
    }

    Scaffold(
        topBar = {
            TopBar(background,viewModel)
        }, content = { paddingValues ->
            Content(list,navController,paddingValues,background,lazyGridState)
        },
        bottomBar = {
            BottomAppBar(navController)
        },
        floatingActionButton = {
            FloatingAction(reachEnd, viewModel)
        }
    )
}