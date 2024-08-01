package com.example.retrofit.presentation.movie.items

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.retrofit.R
import com.example.retrofit.core.Constants
import com.example.retrofit.presentation.components.SimpleText

@Composable
fun TopBar(background: Color) {
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
                Constants.MOVIE_TYPE_POPULAR,
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
            IconButton(onClick = {
                println("Clicked")
            }) {
                Icon(painter = painterResource(id = R.drawable.baseline_downloading_24), contentDescription = null)
            }
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
}