package com.deepakbarad.productcataloguecomposeapp.domain.datasource

import com.deepakbarad.productcataloguecomposeapp.domain.models.ProductCatalogue
import kotlinx.coroutines.flow.Flow

interface IProductDataSource {
    suspend fun getProductsData(): ProductCatalogue
}