package com.example.retrofit.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.example.retrofit.presentation.navigation.NavGraph
import com.example.retrofit.presentation.slide.Slide
import com.example.retrofit.presentation.ui.theme.RetrofitTheme
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RetrofitTheme {
                val navController = rememberNavController()
//                NavGraph(navController = navController)
                Slide()
            }
        }
    }
}