package com.example.retrofit.presentation.search_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.retrofit.presentation.movie_list_screen.items.CardView
import com.example.retrofit.presentation.search_screen.items.Event

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Search(
    viewModel: SearchViewModel = hiltViewModel(),
    navController: NavHostController
) {
    var text by remember { mutableStateOf("") }
    val lazyGridState = rememberLazyGridState()
    var isActive by remember { mutableStateOf(false) }
    var list = viewModel.state.dataItems

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black),
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth(if (isActive) 1f else 0.9f)
                .fillMaxHeight(if (isActive) 0.13f else 0.1f)
                .clip(RoundedCornerShape(30.dp))
                .padding(10.dp),

            contentAlignment = Alignment.TopCenter
        ) {
            SearchBar(
                modifier = Modifier
                    .fillMaxWidth(if (isActive) 1f else 1f)
                    .clip(RoundedCornerShape(30.dp)),

                query = text,
                onQueryChange = {
                    text = it
                    viewModel.onEvent(Event.NameChange(text))
                },
                onSearch = {
                    isActive = false
                    viewModel.getMovie(text)
                    list = viewModel.state.dataItems
                },
                active = isActive,
                onActiveChange = { isActive = it },
                placeholder = { Text("Search...") },
                leadingIcon = { Icon(Icons.Default.Search, contentDescription = null) },
                trailingIcon = {
                    if (isActive) {
                        Icon(Icons.Default.Close, contentDescription = "Clear search",
                            modifier = Modifier.clickable {
                                isActive = false
                                text = ""
                            }
                        )
                    }
                }
            ) {
                // Search suggestions can be added here if needed
            }
        }

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp)
        ) {
            if (list.isEmpty()) {
                Text(text = "Not Movie Found As Name $text")
            } else {
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
                                .clickable(
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
    }
}