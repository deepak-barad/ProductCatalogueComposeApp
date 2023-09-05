package com.deepakbarad.productcataloguecomposeapp.presentation.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.deepakbarad.productcataloguecomposeapp.domain.models.Product
import com.deepakbarad.productcataloguecomposeapp.domain.models.UIState
import com.deepakbarad.productcataloguecomposeapp.presentation.viewmodels.MainViewModel

@OptIn(ExperimentalFoundationApi::class, ExperimentalGlideComposeApi::class)
@Composable
fun CatalogueScreen(viewModel: MainViewModel) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val products: List<Product> by viewModel.productData.collectAsState(
            initial = emptyList()
        )
        val uiState by remember {
            viewModel.showProgress
        }
        CircularIndeterminateProgressBar(uiState)
        LazyColumn(modifier = Modifier.fillMaxWidth()) {
            items(products) { product ->
                Row(
                    modifier = Modifier.padding(top = 16.dp, bottom = 16.dp)
                ) {
                    Column(modifier = Modifier
                        .fillMaxWidth(0.30f)
                        .background(Color.White)) {
                        GlideImage(
                            model = product.images[0],
                            contentDescription = product.title,
                            modifier = Modifier
                                .padding(16.dp)
                                .fillMaxWidth(),
                        )
                    }
                    Column(
                        modifier = Modifier
                            .fillMaxWidth(0.70f)
                            .background(Color.White)
                    ) {
                        Text(
                            product.title,
                            modifier = Modifier
                                .padding(16.dp, 0.dp, 16.dp, 8.dp)
                        )
                        Text(
                            product.description,
                            modifier = Modifier
                                .padding(16.dp, 0.dp, 16.dp, 8.dp)
                        )
                    }
                }
                Divider()
            }
        }
    }
}

@Composable
fun CircularIndeterminateProgressBar(
    uiState: UIState
) {
    if (uiState.showProgress) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CircularProgressIndicator()
        }
    }
}