package com.example.retrofit.presentation.detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import coil.compose.rememberAsyncImagePainter
import com.example.retrofit.presentation.components.SimpleText
import com.example.retrofit.presentation.detail.items.Content
import com.example.retrofit.utils.Constants

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailItemScreen(
    viewModel: MovieDetailViewModel = hiltViewModel(),
    movieId: Int,
    navController: NavHostController
) {
    val sheetState = rememberBottomSheetScaffoldState()
    viewModel.getMovie(movieId)
    viewModel.getPerson(movieId)
    viewModel.getSimilarMovies(movieId)
    val state = viewModel.state.personResult
    val state1 = viewModel.state.similarMovies
    val movie = viewModel.state.movieResult

    BottomSheetScaffold(
        scaffoldState = sheetState,
        sheetContent = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.7f)
                    .background(Color.Black.copy(alpha = 0.9f))
                    .padding(20.dp)

            ) {
                SimpleText(
                    "Cast",
                    FontWeight.Bold,
                    Color.White,
                    32
                )
                LazyRow(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                        .padding(5.dp)
                ) {
                    if (state.isNotEmpty()) {
                        items(state.size) { item ->
                            Card(
                                modifier = Modifier
                                    .width(150.dp)
                                    .height(230.dp)
                                    .padding(2.dp),
                                elevation = CardDefaults.cardElevation(
                                    defaultElevation = 10.dp
                                )
                            ) {
                                Box(
                                    modifier = Modifier
                                        .fillMaxSize()
                                        .background(Color.Gray)
                                        .padding(2.dp)
                                ) {
                                    Row {
                                        Box(
                                            modifier = Modifier
                                                .fillMaxWidth()
                                                .fillMaxHeight()
                                        ) {
                                            val painter = rememberAsyncImagePainter(
                                                model = "${Constants.POSTER_URL}${state[item].profile_path}"
                                            )
                                            Image(
                                                modifier = Modifier
                                                    .fillMaxWidth()
                                                    .fillMaxHeight()
                                                    .clip(RoundedCornerShape(10.dp)),
                                                contentScale = ContentScale.FillBounds,
                                                painter = painter,
                                                contentDescription = null
                                            )
                                        }
                                    }
                                }
                            }
                        }
                    }
                }

                SimpleText(
                    "Similar Movies",
                    FontWeight.Bold,
                    Color.White,
                    32
                )
                LazyRow(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                        .padding(5.dp)
                ) {
                    if (state1.isNotEmpty()) {
                        items(state.size) { item ->
                            Card(
                                modifier = Modifier
                                    .width(150.dp)
                                    .height(230.dp)
                                    .padding(2.dp),
                                elevation = CardDefaults.cardElevation(
                                    defaultElevation = 10.dp
                                )
                            ) {
                                Box(
                                    modifier = Modifier
                                        .fillMaxSize()
                                        .background(Color.Gray)
                                        .padding(2.dp)
                                ) {
                                    Row {
                                        Box(
                                            modifier = Modifier
                                                .fillMaxWidth()
                                                .fillMaxHeight()
                                                .clickable(
                                                    onClick = {
                                                        navController.navigate("detail_item_screen/${state1[item].id}")
                                                    }
                                                )
                                        ) {
                                            val painter = rememberAsyncImagePainter(
                                                model = "${Constants.POSTER_URL}${state1[item].poster_path}"
                                            )
                                            Image(
                                                modifier = Modifier
                                                    .fillMaxWidth()
                                                    .fillMaxHeight()
                                                    .clip(RoundedCornerShape(10.dp)),
                                                contentScale = ContentScale.FillBounds,
                                                painter = painter,
                                                contentDescription = null
                                            )
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        },
        sheetPeekHeight = 50.dp,
        sheetContainerColor = Color.Cyan.copy(alpha = 0.5f)
    ) {
        Content(movie)
    }
}