package com.deepakbarad.productcataloguecomposeapp.domain.usecases

import com.deepakbarad.productcataloguecomposeapp.domain.datasource.IProductDataSource
import com.deepakbarad.productcataloguecomposeapp.domain.models.ProductCatalogue
import javax.inject.Inject

class GetProductsDataUseCase @Inject constructor(private val productRepository: IProductDataSource) {
    suspend operator fun invoke(): ProductCatalogue = productRepository.getProductsData()
}