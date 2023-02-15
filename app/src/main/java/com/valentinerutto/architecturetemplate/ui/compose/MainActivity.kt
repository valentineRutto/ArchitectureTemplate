package com.valentinerutto.architecturetemplate.ui.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.valentinerutto.architecturetemplate.ui.DogImageViewModel
import com.valentinerutto.architecturetemplate.ui.compose.ui.DogListScreen
import com.valentinerutto.architecturetemplate.ui.compose.ui.Header
import com.valentinerutto.architecturetemplate.ui.compose.ui.theme.ArchitectureTemplateTheme
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : ComponentActivity() {
    private val dogImageViewModel: DogImageViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dogImageViewModel.fetchImage()

        setContent {
            ArchitectureTemplateTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = androidx.compose.ui.Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Column(Modifier.fillMaxWidth()) {
                        TopAppBar(title = { Header(name = "Compose UI") })
                        Spacer(modifier = Modifier.height(8.dp))

                        DogListScreen(dogImageViewModel = dogImageViewModel)
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {

    ArchitectureTemplateTheme {
    }
}