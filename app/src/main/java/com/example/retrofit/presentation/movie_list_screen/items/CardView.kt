package com.example.retrofit.presentation.movie_list_screen.items

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.retrofit.utils.Constants
import com.example.retrofit_api.movie_app.movie_model.Result

@Composable
fun CardView(
    itemIndex: Int,
    list: List<Result>,
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(2.dp)
            .height(230.dp),
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
            Column {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight()
                ) {
                    val painter = rememberAsyncImagePainter(
                        model = "${Constants.POSTER_URL}${list[itemIndex].poster_path}"
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
