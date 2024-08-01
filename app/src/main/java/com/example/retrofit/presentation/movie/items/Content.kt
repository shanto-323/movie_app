package com.example.retrofit.presentation.movie.items

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyGridState
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.retrofit_api.movie_app.movie_model.MovieResult

@Composable
fun Content(
    list: List<MovieResult>,
    navController: NavHostController,
    paddingValues: PaddingValues,
    background: Color,
    lazyGridState: LazyGridState
) {
    Column(
        modifier = Modifier
            .padding(paddingValues)
            .background(background),
    ) {
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            state = lazyGridState,
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp, 10.dp)
        ) {
            items(list.size) {
                ItemsScreen(it, list,navController)
            }
        }
    }
}