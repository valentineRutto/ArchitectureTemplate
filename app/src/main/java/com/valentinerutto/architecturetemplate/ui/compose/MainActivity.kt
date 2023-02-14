package com.valentinerutto.architecturetemplate.ui.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.valentinerutto.architecturetemplate.data.DogImage
import com.valentinerutto.architecturetemplate.ui.DogImageViewModel
import com.valentinerutto.architecturetemplate.ui.compose.ui.ImageComposable
import com.valentinerutto.architecturetemplate.ui.compose.ui.theme.ArchitectureTemplateTheme
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : ComponentActivity() {
    private val dogImageViewModel: DogImageViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArchitectureTemplateTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = androidx.compose.ui.Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    //todo dgimgurl is empty ???
                    val dogImageurl = dogImageViewModel.image.collectAsState().value
                    DogImage(dogImage = dogImageurl)
                    println("dog" + dogImageurl.url)
                }
            }
        }
    }
}

@Composable
fun DogImage(dogImage: DogImage) {
    Header("Compose UI")

    Spacer(modifier = Modifier.height(8.dp))

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
            ImageComposable(imageUrl = "${dogImage.url!!}", Modifier.fillMaxSize(0.5f))

        }
    }
}

@Composable
fun Header(name: String) {
    Text(text = name)
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {

    ArchitectureTemplateTheme {
        Header("Android")

        com.valentinerutto.architecturetemplate.ui.compose.DogImage(dogImage = DogImage("https://images.dog.ceo/breeds/eskimo/n02109961_630.jpg"))
    }
}