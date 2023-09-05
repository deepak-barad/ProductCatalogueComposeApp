package com.deepakbarad.productcataloguecomposeapp.presentation.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.deepakbarad.productcataloguecomposeapp.presentation.screens.CatalogueScreen
import com.deepakbarad.productcataloguecomposeapp.presentation.theme.ProductCatalogueComposeAppTheme
import com.deepakbarad.productcataloguecomposeapp.presentation.viewmodels.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val mainViewModel = hiltViewModel<MainViewModel>()
            LaunchedEffect(Unit, block = {
                mainViewModel.getProductsData()
            })
            ProductCatalogueComposeAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    CatalogueScreen(mainViewModel)
                }
            }
        }
    }
}