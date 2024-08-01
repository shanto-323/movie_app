package com.example.retrofit.presentation.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SimpleText(
    title : String = "",
    fontWeight: FontWeight = FontWeight.Normal,
    color: Color = Color.White,
    fontSize : Int = 8
) {
    Text(
        text = title,
        fontWeight = fontWeight,
        color = color,
        fontSize = fontSize.sp
    )
}