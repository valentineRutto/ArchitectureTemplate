package com.valentinerutto.architecturetemplate.ui.compose.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import coil.compose.AsyncImage

@Composable
internal fun ImageComposable(
    imageUrl: String,
    modifier: Modifier = Modifier,
) {
    AsyncImage(
        model = imageUrl,
        modifier = modifier,
        alignment = Alignment.Center,
        contentDescription = "Dog image"
    )
}