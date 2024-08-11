package com.example.retrofit.presentation.slide

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberAsyncImagePainter
import com.example.retrofit.core.Constants
import com.example.retrofit.presentation.components.SimpleText
import com.example.retrofit.presentation.movie.items.CardView

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Slide(
    viewModel: SlideViewModel = hiltViewModel()
) {
    val state = viewModel.state.image
    val pagerState = rememberPagerState(pageCount = { 5 })
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(10.dp)
    ) {
        Box(
            modifier = Modifier.padding(5.dp)
        ) {
            SimpleText(
                "NETFLIX",
                color = Color.Black,
                fontSize = 32,
                fontWeight = FontWeight.Bold
            )
        }
        HorizontalPager(
            state = pagerState,
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.5f)
        ) { page ->
            val painter = rememberAsyncImagePainter(
                model = "${Constants.POSTER_URL}${state[page].poster_path}"
            )
            Surface(
                shape = RoundedCornerShape(10.dp),
                modifier = Modifier
                    .fillMaxSize()
                    .padding(5.dp)

            ) {
                Image(
                    painter = painter,
                    contentDescription = "null",
                    contentScale = ContentScale.FillBounds,
                    modifier = Modifier
                        .fillMaxHeight(0.9f)
                        .fillMaxWidth()
                )
                Column(
                    modifier = Modifier
                        .fillMaxHeight(0.7f)
                        .fillMaxWidth()
                        .background(Color.Black.copy(alpha = 0.6f))
                        .padding(20.dp, 10.dp),
                    horizontalAlignment = Alignment.Start,
                    verticalArrangement = Arrangement.Bottom
                ) {
                    Text(
                        text = state[page].title,
                        fontWeight = FontWeight.Bold,
                        fontSize = 24.sp
                    )
                    Text(
                        text = state[page].overview,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 8.sp,
                        lineHeight = 11.sp
                    )
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(10.dp),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        repeat(5) { iteration ->
                            val color = if (page == iteration) Color.Green else Color.LightGray
                            Box(
                                modifier = Modifier
                                    .padding(2.dp)
                                    .clip(CircleShape)
                                    .background(color)
                                    .size(8.dp)
                            )
                        }
                    }
                }


            }
        }
        Spacer(modifier = Modifier.padding(10.dp))

        Box(
            modifier = Modifier.padding(5.dp)
        ) {
            SimpleText(
                "New Movies",
                color = Color.Black,
                fontSize = 24,
                fontWeight = FontWeight.SemiBold
            )
        }

        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .padding(5.dp)
        ) {
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
                                    model = "${Constants.POSTER_URL}${state[item].poster_path}"
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