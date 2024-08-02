package com.example.retrofit.presentation.detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import coil.compose.rememberAsyncImagePainter
import com.example.retrofit.R
import com.example.retrofit.core.Constants
import com.example.retrofit.presentation.components.SimpleText
import com.example.retrofit.presentation.detail.items.Content

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailItemScreen(
    viewModel: MovieDetailViewModel = hiltViewModel(),
    itemIndex: Int,
    navController : NavHostController
) {
    val sheetState = rememberBottomSheetScaffoldState()
    viewModel.getMovie(itemIndex)
    val movie = viewModel.state.movieResult

    BottomSheetScaffold(
        scaffoldState = sheetState,
        sheetContent = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.5f)
                    .padding(10.dp)
            ) {
                SimpleText(
                    "Movie Details",
                    FontWeight.Bold,
                    Color.Black,
                    32
                )
                Spacer(modifier = Modifier.padding(10.dp))
                Button(onClick = {
                    navController.navigate(route = "video_screen/" + movie?.id)
                }) {
                    SimpleText(
                        "Watch",
                        FontWeight.Bold,
                        Color.Black,
                        32
                    )
                }
            }
        },
        sheetPeekHeight = 100.dp,
        sheetContainerColor = Color.Green
    ) {
        Content(movie)
    }
}