package com.example.retrofit.presentation.slide.items

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.example.retrofit.R
import com.example.retrofit.presentation.components.SimpleText
import com.example.retrofit.utils.Constants
import com.example.retrofit_api.movie_app.movie_model.Result

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Pager(state: List<Result>) {
    val pagerState = rememberPagerState(pageCount = { 5 })
    HorizontalPager(
        state = pagerState,
        modifier = Modifier
            .fillMaxWidth()
            .height(400.dp)
    ) { page ->
        Box(
            modifier = Modifier
                .fillMaxSize()
        ) {
            if (state.isNotEmpty()) {
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
                            .fillMaxSize()
                            .background(Color.Black.copy(alpha = 0.7f))
                            .padding(20.dp, 10.dp),
                        horizontalAlignment = Alignment.Start,
                        verticalArrangement = Arrangement.Bottom
                    ) {

                        SimpleText(
                            title = state[page].title,
                            fontWeight = FontWeight.Bold,
                            fontSize = 24,
                            color = Color.White
                        )

                        Text(
                            text = state[page].overview,
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 12.sp,
                            lineHeight = 12.sp,
                            color = Color.White
                        )
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(10.dp),
                            horizontalArrangement = Arrangement.Center,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            repeat(5) { iteration ->
                                val color =
                                    if (page == iteration) Color.Green else Color.LightGray
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

                Row (
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.End
                ){
                    Column(
                        modifier = Modifier
                            .fillMaxWidth(0.5f)
                            .height(240.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center

                    ) {
                        Button(
                            onClick = { /*TODO*/ },
                            modifier = Modifier
                                .fillMaxWidth(0.8f),
                            colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
                            border = BorderStroke(2.dp, Color.White)
                        ) {
                            Row (
                                modifier = Modifier
                                    .fillMaxWidth(),
                                horizontalArrangement = Arrangement.End
                            ){
                                Text(
                                    modifier = Modifier
                                        .fillMaxWidth(0.8f),
                                    text = "Play",
                                    textAlign = TextAlign.Center,
                                    fontWeight = FontWeight.Bold,
                                    color = Color.White
                                )
                                Icon(painter = painterResource(
                                    id = R.drawable.baseline_bookmark_add_24)
                                    , contentDescription = null,
                                    tint = Color.White
                                )
                            }

                        }
                    }

                    Image(
                        painter = painter,
                        contentDescription = "null",
                        contentScale = ContentScale.FillBounds,
                        modifier = Modifier
                            .height(240.dp)
                            .aspectRatio(0.8f)
                            .padding(20.dp)
                            .clip(RoundedCornerShape(10.dp))
                    )
                }
            }
        }
    }

}