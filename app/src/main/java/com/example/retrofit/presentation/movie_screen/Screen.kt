package com.example.retrofit.presentation.movie_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.retrofit.presentation.movie_screen.items.helper_screen.ItemsScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Screen(
    viewModel: ScreenViewModel = hiltViewModel(),
    navController: NavHostController
) {

    val list = viewModel.state.dataItems

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.background)
            .padding(18.dp)
    ) {
        Scaffold(topBar = {
            TopAppBar(title = {
                Text("Student List")
            })
        }, content = { paddingValues ->
            Column(
                modifier = Modifier.padding(paddingValues)
            ) {
                LazyVerticalGrid(
                    columns = GridCells.Fixed(2),
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(10.dp)
                ) {
                    items(list.size) {
                        ItemsScreen(it, list,navController)
                    }
                }
            }
        })
    }
}