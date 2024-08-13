package com.example.retrofit.presentation.detail.items

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.retrofit.utils.Constants
import com.example.retrofit.presentation.components.SimpleText
import com.example.retrofit_api.movie_app.movie_model.Result

@Composable
fun Content(movie: Result?) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Box(
            contentAlignment = Alignment.Center
        ) {
            val painter = rememberAsyncImagePainter(
                model = "${Constants.POSTER_URL}${movie?.poster_path}"
            )
            Image(
                modifier = Modifier
                    .fillMaxWidth(0.6f)
                    .fillMaxHeight(0.4f)
                    .clip(RoundedCornerShape(10.dp)),
                contentScale = ContentScale.FillBounds,
                painter = painter,
                contentDescription = null,

                )
        }
        Column(
            modifier = Modifier
                .fillMaxHeight(0.4f)
                .fillMaxWidth()
                .background(Color.Black)
                .padding(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            if (movie != null) {
                SimpleText(
                    movie.title,
                    FontWeight.ExtraBold,
                    Color.White,
                    24
                )
                SimpleText(
                    "Release Date : ${movie.release_date}",
                    FontWeight.Bold,
                    Color.White,
                    16
                )
                SimpleText(
                    "Rating : ${movie.vote_average}",
                    FontWeight.Bold,
                    Color.White,
                    16
                )
                SimpleText(
                    "Vote Count : ${movie.vote_count}",
                    FontWeight.Bold,
                    Color.White,
                    16
                )
            }

        }
    }
}