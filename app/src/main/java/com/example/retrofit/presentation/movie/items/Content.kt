package com.example.retrofit.presentation.movie.items

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.retrofit.presentation.movie.ScreenViewModel
import com.example.retrofit_api.movie_app.movie_model.Result

@Composable
fun Content(
    list: List<Result>,
    navController: NavHostController,
    paddingValues: PaddingValues,
    background: Color,
    viewModel: ScreenViewModel,
//    lazyGridState: LazyGridState
) {
    Column(
        modifier = Modifier
            .padding(paddingValues)
            .background(background),
    ) {
//        LazyVerticalGrid(
//            columns = GridCells.Fixed(2),
////            state = lazyGridState,
//            modifier = Modifier
//                .fillMaxSize()
//                .padding(20.dp, 10.dp)
//        ) {
//            items(list.size) {
//                Box(
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .clickable (
//                            onClick = {
//                                println("inSide")
//                                navController.navigate(route = "detail_item_screen/" + list[it].id)
//                            }
//                        )
//                ) {
//                    CardView(it, list)
//                }
//            }
//        }


        LazyColumn{
            items(list.size){
                if(it >= list.size - 1 && !viewModel.state.endReached && !viewModel.state.isLoading){
                    viewModel.loadNext()
                }
                Text(
                    text = viewModel.state.dataItems[it].title,
                )
            }
        }


    }
}