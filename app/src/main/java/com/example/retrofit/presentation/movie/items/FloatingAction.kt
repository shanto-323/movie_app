package com.example.retrofit.presentation.movie.items

import androidx.compose.foundation.background
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.retrofit.R
import com.example.retrofit.presentation.movie.ScreenViewModel

@Composable
fun FloatingAction(
    reachEnd: Boolean,
    viewModel: ScreenViewModel
) {
    if (reachEnd) {
        IconButton(
            onClick = {
//                viewModel.onEvent(event)
            },
            modifier = Modifier
                .clip(RoundedCornerShape(20.dp))
                .background(Color.Black)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.right_next),
                contentDescription = null
            )
        }
    }
}