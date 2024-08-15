package com.example.retrofit.presentation.detail.items

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.example.retrofit.utils.Constants
import com.example.retrofit.presentation.components.SimpleText
import com.example.retrofit_api.movie_app.movie_model.Result

@Composable
fun Content(movie: Result?) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize(),
            contentAlignment = Alignment.TopEnd
        ) {
            val painter = rememberAsyncImagePainter(
                model = "${Constants.POSTER_URL}${movie?.poster_path}"
            )
            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(0.6f),
                contentScale = ContentScale.FillBounds,
                painter = painter,
                contentDescription = null,

                )
            Column(
                modifier = Modifier
                    .background(Color.Black.copy(alpha = 0.8f))
                    .fillMaxWidth()
                    .aspectRatio(0.5f)
                    .padding(10.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Image(
                    modifier = Modifier
                        .fillMaxWidth(0.6f)
                        .fillMaxHeight(0.4f)
                        .clip(RoundedCornerShape(10.dp)),
                    contentScale = ContentScale.FillBounds,
                    painter = painter,
                    contentDescription = null,

                    )
                Spacer(modifier = Modifier.padding(10.dp))
                if (movie != null) {
                    SimpleText(
                        movie.title,
                        FontWeight.ExtraBold,
                        Color.White,
                        18
                    )
                    Text(
                        text = "${movie.release_date}" +
                                "\n${movie.vote_average}" +
                                "\n\n${movie.overview}",
                        color = Color.White,
                        textAlign = TextAlign.Center,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.SemiBold,
                        lineHeight = 14.sp
                    )
                }
            }
        }
    }
}