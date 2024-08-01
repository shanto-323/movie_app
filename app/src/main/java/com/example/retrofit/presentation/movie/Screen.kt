package com.example.retrofit.presentation.movie

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.retrofit.R
import com.example.retrofit.core.Constants
import com.example.retrofit.presentation.components.SimpleText
import com.example.retrofit.presentation.movie.items.Content
import com.example.retrofit.presentation.movie.items.FloatingAction
import com.example.retrofit.presentation.movie.items.TopBar

@Composable
fun Screen(
    viewModel: ScreenViewModel = hiltViewModel(),
    navController: NavHostController
) {
    viewModel.fetchData()
    val list = viewModel.state.dataItems
    val background = colorResource(id = R.color.offBlack)

    val lazyGridState = rememberLazyGridState()
    val reachEnd by remember {
        derivedStateOf {
            val layoutInfo = lazyGridState.layoutInfo
            val totalItems = layoutInfo.totalItemsCount
            val lastVisibleIndex = (layoutInfo.visibleItemsInfo.lastOrNull()?.index ?: 0) + 1
            lastVisibleIndex == totalItems
        }
    }

    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        topBar = {
            TopBar(background)
        }, content = { paddingValues ->
            Content(list,navController,paddingValues,background,lazyGridState)
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
//                BoxButton (
//                    painter = painterResource(id = R.drawable.baseline_downloading_24),
//                    onClick = {
//
//                    },
//                    alignment = Alignment.CenterStart
//                )
//                BoxButton (
//                    painter = painterResource(id = R.drawable.baseline_search_24),
//                    onClick = {
//
//                    },
//                    alignment = Alignment.CenterStart
//                )
//                BoxButton (
//                    painter = painterResource(id = R.drawable.baseline_bookmark_add_24),
//                    onClick = {
//
//                    },
//                    alignment = Alignment.CenterStart
//                )
//                BoxButton (
//                    painter = painterResource(id = R.drawable.baseline_face_24),
//                    onClick = {
//
//                    },
//                    alignment = Alignment.CenterStart
//                )
            }
        },
        floatingActionButton = {
            FloatingAction(reachEnd, viewModel)
        }
    )
}