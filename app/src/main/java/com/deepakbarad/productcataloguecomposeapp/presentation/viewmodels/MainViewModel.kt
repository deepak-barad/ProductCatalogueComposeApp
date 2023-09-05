package com.deepakbarad.productcataloguecomposeapp.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.deepakbarad.productcataloguecomposeapp.domain.models.Product
import com.deepakbarad.productcataloguecomposeapp.domain.repository.ProductRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
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