package com.example.retrofit.presentation.detail.items

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberAsyncImagePainter
import com.example.retrofit.R
import com.example.retrofit.core.Constants
import com.example.retrofit.presentation.components.SimpleText
import com.example.retrofit.presentation.detail.MovieDetailViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomSheet(
    viewModel: MovieDetailViewModel = hiltViewModel(),
    itemIndex: Int
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        SimpleText(
            "Movie Details",
            FontWeight.Bold,
            Color.Black,
            32
        )
        Spacer(modifier = Modifier.padding(10.dp))
        Image(painter = painterResource(id = R.drawable.poster), contentDescription = "")
    }
}

@Composable
fun VideoView(id: Int) {
    val webView = rememberWebViewState(url = "${Constants.VIDEO_LINK}$id")
    WebView(
        modifier = Modifier
            .fillMaxWidth()
            .height(300.dp)
            .clickable(
                enabled = true,onClick = {}),
        state = webView,
        onCreated = {
            it
            it.settings.javaScriptEnabled = true
            it.settings.mediaPlaybackRequiresUserGesture = false
        },
        captureBackPresses = false
    )
}







