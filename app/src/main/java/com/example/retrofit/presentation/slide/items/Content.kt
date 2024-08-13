package com.example.retrofit.presentation.slide.items

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.retrofit.presentation.components.SimpleText
import com.example.retrofit.presentation.slide.SlideViewModel

@Composable
fun Content(
    navController: NavHostController,
    paddingValues: PaddingValues,
    viewModel: SlideViewModel
) {
    val state = viewModel.state.image
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(paddingValues)
            .verticalScroll(scrollState)
    ) {
        Pager(state)
        Box(
            modifier = Modifier.padding(5.dp)
        ) {
            SimpleText(
                "Trending Now",
                color = Color.White,
                fontSize = 18,
                fontWeight = FontWeight.Normal
            )
        }
        Spacer(modifier = Modifier.padding(10.dp))

        Box(
            modifier = Modifier.padding(5.dp)
        ) {
            SimpleText(
                "New Movies                -More",
                color = Color.White,
                fontSize = 24,
                fontWeight = FontWeight.SemiBold
            )
        }

        ItemPosition(state)
        Spacer(modifier = Modifier.padding(10.dp))
    }
}