package com.example.retrofit.presentation.temp_screen_create

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.retrofit.R
import com.example.retrofit.core.Constants

@Composable
fun BoxButton(
    painter: Painter = painterResource(id = R.drawable.ic_launcher_foreground),
    onClick: () -> Unit,
    alignment: Alignment = Alignment.Center
) {
    Box(
        modifier = Modifier
            .height(40.dp)
            .width(40.dp)
            .clip(RoundedCornerShape(30.dp)),
        contentAlignment = Alignment.Center,
    ) {
        Icon(
            painter = painter,
            contentDescription = null,
            modifier = Modifier
                .size(20.dp, 40.dp)
                .clickable (
                    onClick = {
                        onClick
                    }
                ),
            tint = Color.White
        )
    }
}