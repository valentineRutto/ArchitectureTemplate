package com.valentinerutto.architecturetemplate.ui.compose.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.valentinerutto.architecturetemplate.data.DogImage
import com.valentinerutto.architecturetemplate.ui.DogImageViewModel

@Composable
fun DogListScreen(dogImageViewModel: DogImageViewModel) {
    val dogImageurl = dogImageViewModel.image.collectAsState().value
    DogImage(dogImage = dogImageurl)

}

@Composable
fun DogImage(dogImage: DogImage) {


    Card(
        shape = RoundedCornerShape(14.dp), backgroundColor = Color.White,
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth(), elevation = 5.dp
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),

            ) {
            ImageComposable(imageUrl = "${dogImage.url!!}", Modifier.fillMaxSize())

        }
    }
}

@Composable
fun Header(name: String, modifier: Modifier = Modifier) {
    Text(text = name, fontWeight = FontWeight.Bold, modifier = modifier.padding(10.dp))
}
