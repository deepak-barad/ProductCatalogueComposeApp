package com.deepakbarad.productcataloguecomposeapp.presentation.viewmodels

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.deepakbarad.productcataloguecomposeapp.domain.models.Product
import com.deepakbarad.productcataloguecomposeapp.domain.models.UIState
import com.deepakbarad.productcataloguecomposeapp.domain.models.UseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val useCases: UseCases,
    private val ioDispatcher: CoroutineDispatcher
) : ViewModel() {
    private var mProductData: MutableStateFlow<List<Product>> = MutableStateFlow(emptyList())
    private var mShowProgress = mutableStateOf<UIState>(UIState(false))
    val productData: MutableStateFlow<List<Product>>
        get() = mProductData

    val showProgress: MutableState<UIState>
        get() {
            return mShowProgress
        }

    fun getProductsData() {
        mShowProgress.value = UIState(true)
        viewModelScope.launch(ioDispatcher) {
            mProductData.update {
                useCases.getProductsDataUseCase().products
            }
            mShowProgress.value = UIState(false)
        }
    }
}