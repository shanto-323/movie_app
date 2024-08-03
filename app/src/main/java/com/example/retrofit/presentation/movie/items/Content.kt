package com.example.retrofit.presentation.movie.items

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyGridState
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.Icon
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.retrofit.R
import com.example.retrofit.core.Constants
import com.example.retrofit.presentation.components.SimpleText
import com.example.retrofit_api.movie_app.movie_model.Result

@Composable
fun Content(
    list: List<Result>,
    navController: NavHostController,
    paddingValues: PaddingValues,
    background: Color,
    lazyGridState: LazyGridState
) {
    Column(
        modifier = Modifier
            .padding(paddingValues)
            .background(background),
    ) {
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            state = lazyGridState,
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp, 10.dp)
        ) {
            items(list.size) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable (
                            onClick = {
                                println("inSide")
                                navController.navigate(route = "detail_item_screen/" + list[it].id)
                            }
                        )
                ) {
                    CardView(it, list)
                }
            }
        }
    }
}