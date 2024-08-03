package com.example.retrofit.presentation.movie.items

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.retrofit.core.Constants
import com.example.retrofit.presentation.components.SimpleText
import com.example.retrofit.presentation.movie.ScreenViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DropDownMenu(viewModel: ScreenViewModel) {
    var isExpandManuBar by remember {
        mutableStateOf(false)
    }

    var itemName by remember {
        mutableStateOf("All")
    }

    ExposedDropdownMenuBox(
        expanded = isExpandManuBar,
        onExpandedChange = { isExpandManuBar = it }
    ) {
        TextField(
            modifier = Modifier
                .menuAnchor(),
            value = "",
            onValueChange = {},
            readOnly = true,
            trailingIcon = {
                ExposedDropdownMenuDefaults.TrailingIcon(expanded = isExpandManuBar)
            },
            placeholder = {
                SimpleText(
                    itemName,
                    FontWeight.SemiBold,
                    Color.White,
                    14
                )
            },
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Color.Black,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
            )
        )

        ExposedDropdownMenu(
            expanded = isExpandManuBar,
            onDismissRequest = { isExpandManuBar = false },
            modifier = Modifier
                .fillMaxWidth(0.4f)
                .border(2.dp, Color.White)
        ) {
            Column {

            }
            TextButton(
                onClick = {
                    isExpandManuBar = false
                    itemName = "POPULAR"
                    viewModel.onEvent(Event.PopularButtonClicked)
                }
            ) {
                SimpleText(
                    "POPULAR",
                    FontWeight.SemiBold,
                    Color.White,
                    14
                )
            }
            TextButton(
                onClick = {
                    isExpandManuBar = false
                    itemName = "UPCOMING"
                    viewModel.onEvent(Event.UpcomingButtonClicked)
                }
            ) {
                SimpleText(
                    "UPCOMING",
                    FontWeight.SemiBold,
                    Color.White,
                    14

                )
            }
            TextButton(
                onClick = {
                    isExpandManuBar = false
                    itemName = "TOP_RATED"
                    viewModel.onEvent(Event.TopRatedButtonClicked)
                }
            ) {
                SimpleText(
                    "TOP_RATED",
                    FontWeight.SemiBold,
                    Color.White,
                    14
                )
            }

        }

    }
}