package com.deepakbarad.productcataloguecomposeapp.presentation.viewmodels

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.deepakbarad.productcataloguecomposeapp.domain.models.Product
import com.deepakbarad.productcataloguecomposeapp.domain.repository.ProductRepository
import com.deepakbarad.productcataloguecomposeapp.domain.models.ProductCatalogue
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.shareIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repository: ProductRepository) : ViewModel() {
    private var mProductData: MutableStateFlow<List<Product>> = MutableStateFlow(emptyList())

    val productData: MutableStateFlow<List<Product>>
        get() = mProductData

    fun getProductsData() {
        viewModelScope.launch(Dispatchers.IO) {
            mProductData.update {
                repository.getProductsData().products
            }
        }
    }
}