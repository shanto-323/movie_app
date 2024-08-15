package com.example.retrofit.presentation.movie.items

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.retrofit.R
import com.example.retrofit.presentation.movie.ScreenViewModel
import com.example.retrofit.utils.Constants

@Composable
fun TopBar(
    background: Color,
    viewModel: ScreenViewModel,
    navController: NavHostController
) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(background),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Spacer(modifier = Modifier.padding(10.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth(0.9f)
                .fillMaxHeight(0.1f)
                .clip(RoundedCornerShape(30.dp))
                .background(Color.Black)
                .padding(18.dp, 5.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Box(
                modifier = Modifier
                    .padding(5.dp)
                    .border(2.dp, Color.White, RoundedCornerShape(24.dp))
                    .fillMaxHeight()
                    .aspectRatio(1.2f),
                contentAlignment = Alignment.Center
            ) {
                IconButton(
                    onClick = {
                        navController.navigate(Constants.MAIN_SCREEN)
                    }
                ){
                    Icon(
                        painter = painterResource(
                            id = R.drawable.baseline_home_24
                        ),
                        contentDescription = "null",
                    )
                }

            }

            DropDownMenu(viewModel)
        }
    }
}