package com.deepakbarad.productcataloguecomposeapp.presentation.activities.screens

import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.LocalTextStyle
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ClipboardManager
import androidx.compose.ui.platform.LocalClipboardManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.deepakbarad.productcataloguecomposeapp.domain.models.Product
import com.deepakbarad.productcataloguecomposeapp.presentation.viewmodels.MainViewModel
import java.util.concurrent.Flow

@OptIn(ExperimentalFoundationApi::class)
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
        LazyColumn(modifier = Modifier.fillMaxWidth()) {
            items(products) { product ->
                Row(
                    modifier = Modifier.padding(top = 16.dp, bottom = 16.dp)
                ) {
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
                    Column(modifier = Modifier.background(Color.White)) {


                    }
                }
                Divider()
            }
        }
    }
}