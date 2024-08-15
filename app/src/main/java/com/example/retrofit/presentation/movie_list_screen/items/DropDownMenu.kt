package com.example.retrofit.presentation.movie_list_screen.items

import androidx.compose.foundation.border
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
import com.example.retrofit.presentation.components.SimpleText
import com.example.retrofit.presentation.movie_list_screen.ScreenViewModel

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
            SimpleTextButton(
                viewModel = viewModel,
                text = "POPULAR",
                isItemName = { itemName = it },
                itemIsExpandManuBar = { isExpandManuBar = it }
            )
            SimpleTextButton(
                viewModel = viewModel,
                text = "UPCOMING",
                isItemName = { itemName = it },
                itemIsExpandManuBar = { isExpandManuBar = it }
            )
            SimpleTextButton(
                viewModel = viewModel,
                text = "TOP_RATED",
                isItemName = { itemName = it },
                itemIsExpandManuBar = { isExpandManuBar = it }
            )

        }

    }
}


@Composable
fun SimpleTextButton(
    viewModel: ScreenViewModel,
    itemIsExpandManuBar: (Boolean) -> Unit,
    isItemName: (String) -> Unit,
    text: String
) {
    TextButton(
        onClick = {
            itemIsExpandManuBar(false)
            isItemName(text)
            viewModel.onEvent(Event.TopRatedButtonClicked)
        }
    ) {
        SimpleText(
            text,
            FontWeight.SemiBold,
            Color.White,
            14
        )
    }
}