package com.deepakbarad.productcataloguecomposeapp

import com.deepakbarad.productcataloguecomposeapp.common.mockdata.MockProduct
import com.deepakbarad.productcataloguecomposeapp.domain.models.UseCases
import com.deepakbarad.productcataloguecomposeapp.domain.repository.ProductRepository
import com.deepakbarad.productcataloguecomposeapp.domain.usecases.GetProductsDataUseCase
import com.deepakbarad.productcataloguecomposeapp.presentation.viewmodels.MainViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

@RunWith(JUnit4::class)
class MainViewModelTest {

    @Mock
    private lateinit var productRepository: ProductRepository
    private lateinit var mainViewModel: MainViewModel
    private lateinit var useCases: UseCases
    private lateinit var getProductDataUseCases: GetProductsDataUseCase

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        getProductDataUseCases = GetProductsDataUseCase(productRepository)
        useCases = UseCases(getProductDataUseCases)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun getProductsDataTest() = runTest {
        val testDispatcher = UnconfinedTestDispatcher(testScheduler)
        Dispatchers.setMain(testDispatcher)
        try {
            mainViewModel = MainViewModel(useCases, testDispatcher)
            Mockito.`when`(productRepository.getProductsData()).thenReturn(
                MockProduct.productCatalogue()
            )
            val productData = mainViewModel.productData
            Assert.assertTrue(productData.value.isEmpty())
            mainViewModel.getProductsData()
            Assert.assertTrue(productData.value.isNotEmpty())
            Assert.assertTrue(productData.value[0].id == 1)
            Assert.assertTrue(productData.value[0].title == "Test Title")
        } finally {
            Dispatchers.resetMain()
        }
    }
}