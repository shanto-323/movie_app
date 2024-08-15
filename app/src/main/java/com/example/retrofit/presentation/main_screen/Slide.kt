package com.example.retrofit.presentation.main_screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.retrofit.presentation.components.SimpleText
import com.example.retrofit.presentation.main_screen.items.BottomAppBar
import com.example.retrofit.presentation.main_screen.items.Content


@Composable
fun Slide(
    viewModel: SlideViewModel = hiltViewModel(),
    navController: NavHostController
) {
    Scaffold(
        topBar = {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(80.dp)
                    .padding(5.dp),
                contentAlignment = Alignment.Center
            ) {
                SimpleText(
                    "MOFLIX",
                    color = Color.White,
                    fontSize = 32,
                    fontWeight = FontWeight.Bold
                )
            }
        }, content = { paddingValues ->
           Content(
               navController,
               paddingValues,
               viewModel
           )
        },
        bottomBar = {
            BottomAppBar(navController)
        }
    )
}