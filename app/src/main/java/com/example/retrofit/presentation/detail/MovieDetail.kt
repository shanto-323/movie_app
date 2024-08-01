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
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberAsyncImagePainter
import com.example.retrofit.core.Constants
import com.example.retrofit.presentation.components.SimpleText

@Composable
fun DetailItemScreen(
    viewModel: MovieDetailViewModel = hiltViewModel(),
    itemIndex: Int
) {
    val scrollState = rememberScrollState()
    viewModel.getMovie(itemIndex)
    val movie = viewModel.state.movieResult
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(20.dp)
            .verticalScroll(scrollState)
    ) {
        Spacer(modifier = Modifier.padding(10.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                val painter = rememberAsyncImagePainter(
                    model = "${Constants.POSTER_URL}${movie?.poster_path}"
                )
                Image(
                    modifier = Modifier
                        .fillMaxWidth(0.5f)
                        .fillMaxHeight()
                        .padding(5.dp, 20.dp)
                        .clip(RoundedCornerShape(10.dp)),
                    contentScale = ContentScale.FillBounds,
                    painter = painter,
                    contentDescription = null
                )
            }
        }
        Box(
            modifier = Modifier
                .fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                if (movie != null) {
                    SimpleText(
                        movie.title,
                        FontWeight.Bold,
                        Color.White,
                        20
                    )
                }
                Spacer(modifier = Modifier.padding(10.dp))
                Column(
                    horizontalAlignment = Alignment.Start
                ){
                    if (movie != null) {
                        SimpleText(
                            "Release Date : ${movie.release_date}",
                            FontWeight.Medium,
                            Color.White,
                            12
                        )
                        SimpleText(
                            "Adult : ${movie.adult}",
                            FontWeight.Medium,
                            Color.White,
                            12
                        )

                        SimpleText(
                            "Language : ${movie.original_language}",
                            FontWeight.Medium,
                            Color.White,
                            12
                        )
                        SimpleText(
                            "Rating : ${movie.vote_average}",
                            FontWeight.Medium,
                            Color.White,
                            12
                        )
                        SimpleText(
                            "Vote Count : ${movie.vote_count}",
                            FontWeight.Medium,
                            Color.White,
                            12
                        )
                    }
                }
            }

        }

        Spacer(modifier = Modifier.padding(20.dp))
        Column(
            horizontalAlignment = Alignment.Start
        ) {
            val painter = rememberAsyncImagePainter(
                model = "${Constants.POSTER_URL}${movie?.backdrop_path}"
            )
            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(400.dp)
                    .padding(5.dp, 20.dp)
                    .clip(RoundedCornerShape(10.dp)),
                contentScale = ContentScale.FillBounds,
                painter = painter,
                contentDescription = null
            )
            SimpleText(
                "Overview : ${movie?.overview}",
                FontWeight.Medium,
                Color.White,
                12
            )
        }
        Spacer(modifier = Modifier.padding(15.dp))
    }
}