package com.example.retrofit.presentation.slide

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Slide(
    viewModel: SlideViewModel = hiltViewModel()
) {
    viewModel.fetchData()
    val state = viewModel.state.image
    val pagerState = rememberPagerState(pageCount = { 5 })

    if(state != null){
        println("working ${state[0].title}")
    }


//    Column(
//        modifier = Modifier
//            .fillMaxSize()
//            .background(Color.White)
//            .padding(10.dp)
//    ) {
//        Box(
//            modifier = Modifier.padding(5.dp)
//        ) {
//            SimpleText(
//                "NETFLIX",
//                color = Color.Black,
//                fontSize = 32,
//                fontWeight = FontWeight.Bold
//            )
//        }
//        HorizontalPager(
//            state = pagerState,
//            modifier = Modifier
//                .fillMaxWidth()
//                .fillMaxHeight(0.5f)
//        ) { page ->
////            val painter = rememberAsyncImagePainter(
////                model = "${Constants.POSTER_URL}${state[page].poster_path}"
////            )
//            Surface(
//                shape = RoundedCornerShape(10.dp),
//                modifier = Modifier
//                    .fillMaxSize()
//                    .padding(5.dp)
//
//            ) {
////                Image(
////                    painter = painter,
////                    contentDescription = "null",
////                    contentScale = ContentScale.FillBounds,
////                    modifier = Modifier
////                        .fillMaxHeight(0.9f)
////                        .fillMaxWidth()
////                )
//                Column(
//                    modifier = Modifier
//                        .fillMaxHeight(0.7f)
//                        .fillMaxWidth()
//                        .background(Color.Black.copy(alpha = 0.6f))
//                        .padding(20.dp, 10.dp),
//                    horizontalAlignment = Alignment.Start,
//                    verticalArrangement = Arrangement.Bottom
//                ) {
////                    Text(
////                        text = state[page].title,
////                        fontWeight = FontWeight.Bold,
////                        fontSize = 24.sp
////                    )
////                    Text(
////                        text = state[page].overview,
////                        fontWeight = FontWeight.SemiBold,
////                        fontSize = 8.sp,
////                        lineHeight = 11.sp
////                    )
//                    Row(
//                        modifier = Modifier
//                            .fillMaxWidth()
//                            .padding(10.dp),
//                        horizontalArrangement = Arrangement.Center,
//                        verticalAlignment = Alignment.CenterVertically
//                    ) {
//                        repeat(5) { iteration ->
//                            val color = if (page == iteration) Color.Green else Color.LightGray
//                            Box(
//                                modifier = Modifier
//                                    .padding(2.dp)
//                                    .clip(CircleShape)
//                                    .background(color)
//                                    .size(8.dp)
//                            )
//                        }
//                    }
//                }
//
//
//            }
//        }
//        Spacer(modifier = Modifier.padding(10.dp))
//
//
////
////        Box(
////            modifier = Modifier.padding(5.dp)
////        ) {
////            SimpleText(
////                "New Movies",
////                color = Color.Black,
////                fontSize = 24,
////                fontWeight = FontWeight.SemiBold
////            )
////        }
//
////        LazyRow(
////            modifier = Modifier
////                .fillMaxWidth()
////                .height(200.dp)
////                .padding(5.dp)
////        ) {
////            items(state.size) { item ->
////                Card(
////                    modifier = Modifier
////                        .width(150.dp)
////                        .height(230.dp)
////                        .padding(2.dp),
////                    elevation = CardDefaults.cardElevation(
////                        defaultElevation = 10.dp
////                    )
////                ) {
////                    Box(
////                        modifier = Modifier
////                            .fillMaxSize()
////                            .background(Color.Gray)
////                            .padding(2.dp)
////                    ) {
////                        Row {
////                            Box(
////                                modifier = Modifier
////                                    .fillMaxWidth()
////                                    .fillMaxHeight()
////                            ) {
////                                val painter = rememberAsyncImagePainter(
////                                    model = "${Constants.POSTER_URL}${state[item].poster_path}"
////                                )
////                                Image(
////                                    modifier = Modifier
////                                        .fillMaxWidth()
////                                        .fillMaxHeight()
////                                        .clip(RoundedCornerShape(10.dp)),
////                                    contentScale = ContentScale.FillBounds,
////                                    painter = painter,
////                                    contentDescription = null
////                                )
////                            }
////                        }
////                    }
////                }
////            }
////        }
//
//
//    }
}