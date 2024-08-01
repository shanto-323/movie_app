package com.example.retrofit.presentation.movie.items

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.retrofit.R
import com.google.android.material.bottomappbar.BottomAppBar

@Composable
fun BottomAppBar() {
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