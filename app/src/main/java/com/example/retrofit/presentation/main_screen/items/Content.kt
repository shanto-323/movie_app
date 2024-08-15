package com.example.retrofit.presentation.main_screen.items

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.retrofit.presentation.components.SimpleText
import com.example.retrofit.presentation.main_screen.SlideViewModel
import com.example.retrofit.utils.Constants

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
            .padding(10.dp)
            .verticalScroll(scrollState)
    ) {
        Pager(state)
        Box(
            modifier = Modifier.padding(5.dp)
        ) {
            SimpleText(
                "POPULAR  NOW",
                color = Color.White,
                fontSize = 12,
                fontWeight = FontWeight.SemiBold
            )
        }
        Spacer(modifier = Modifier.padding(10.dp))

        Box(
            modifier = Modifier.padding(5.dp)
        ) {
            val text = buildAnnotatedString{
                append("New Movies ")
                pushStringAnnotation(tag = "URL", annotation = "more ->")
                withStyle(
                    style = SpanStyle(
                        color = Color.Red,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                ){
                    append("    SEE MORE")
                }

                pop()
            }
            ClickableText(
                text = text,
                onClick = {
                    text.getStringAnnotations("URL",it, it)
                        .firstOrNull()?.let {
                            println("Working")
                            navController.navigate(Constants.SCREEN)
                        }
                },
                style = androidx.compose.ui.text.TextStyle(
                    color = Color.White,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.SemiBold
                )
            )
        }

        ItemPosition(state,navController)
        Spacer(modifier = Modifier.padding(10.dp))
    }
}