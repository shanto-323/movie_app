package com.example.retrofit.presentation.detail.items

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.retrofit.utils.Constants
import com.google.accompanist.web.WebView
import com.google.accompanist.web.rememberWebViewState

@Composable
fun WebMovie(
    id: Int
) {
    val webView = rememberWebViewState(url = "${Constants.VIDEO_LINK}$id")
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        WebView(
            modifier = Modifier
                .clickable(
                    enabled = true,onClick = {}),
            state = webView,
            onCreated = {
                it.settings.javaScriptEnabled = true
                it.settings.mediaPlaybackRequiresUserGesture = false
            },
            captureBackPresses = false
        )
    }
}







