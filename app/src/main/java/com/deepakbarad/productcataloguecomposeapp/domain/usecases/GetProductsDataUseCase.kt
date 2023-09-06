package com.deepakbarad.productcataloguecomposeapp.domain.usecases

import com.deepakbarad.productcataloguecomposeapp.domain.datasource.IProductDataSource
import com.deepakbarad.productcataloguecomposeapp.domain.models.ProductCatalogue
import com.deepakbarad.productcataloguecomposeapp.domain.repository.ProductRepository
import javax.inject.Inject

class GetProductsDataUseCase @Inject constructor(private val productRepository: ProductRepository) {
    suspend operator fun invoke(): ProductCatalogue = productRepository.getProductsData()
}