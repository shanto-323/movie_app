package com.example.retrofit.presentation.temp_screen_create

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.retrofit.R
import com.example.retrofit.presentation.movie_screen.items.components.SimpleText

@Composable
fun MainScreen(
    titleBar: String = "Popular"
) {
    val background = colorResource(id = R.color.offBlack)
    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        topBar = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(background),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(0.dp, 20.dp, 0.dp, 10.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    SimpleText(
                        titleBar,
                        FontWeight.ExtraBold,
                        Color.White,
                        32
                    )
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth(0.9f)
                        .clip(RoundedCornerShape(30.dp))
                        .background(Color.Black)
                        .padding(30.dp, 8.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    BoxButton (
                        painter = painterResource(id = R.drawable.baseline_search_24),
                        onClick = {

                        },
                        alignment = Alignment.TopStart
                    )
                    SimpleText(
                        "All",
                        FontWeight.Normal,
                        Color.White,
                        14
                    )
                    SimpleText(
                        "Movies",
                        FontWeight.Bold,
                        Color.White,
                        14
                    )
                    SimpleText(
                        "Shows",
                        FontWeight.Bold,
                        Color.White,
                        14
                    )
                }
            }
        }, content = { paddingValues ->
            Column(
                modifier = Modifier
                    .padding(paddingValues)
                    .background(background),
            ) {
                LazyVerticalGrid(
                    columns = GridCells.Fixed(2),
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(20.dp, 10.dp)
                ) {
                    items(10) {
                        Card(painter = painterResource(id = R.drawable.poster))
                    }
                }
            }
        },
        bottomBar = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.Black)
                    .padding(0.dp, 20.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                BoxButton (
                    painter = painterResource(id = R.drawable.baseline_downloading_24),
                    onClick = {

                    },
                    alignment = Alignment.CenterStart
                )
                BoxButton (
                    painter = painterResource(id = R.drawable.baseline_search_24),
                    onClick = {

                    },
                    alignment = Alignment.CenterStart
                )
                BoxButton (
                    painter = painterResource(id = R.drawable.baseline_bookmark_add_24),
                    onClick = {

                    },
                    alignment = Alignment.CenterStart
                )
                BoxButton (
                    painter = painterResource(id = R.drawable.baseline_face_24),
                    onClick = {

                    },
                    alignment = Alignment.CenterStart
                )
            }
        }
    )
}

@Preview
@Composable
private fun MainScreenPreview() {
    MainScreen()
}