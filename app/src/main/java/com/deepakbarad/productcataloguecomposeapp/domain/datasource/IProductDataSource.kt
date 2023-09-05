package com.deepakbarad.productcataloguecomposeapp.domain.datasource

import com.deepakbarad.productcataloguecomposeapp.domain.models.ProductCatalogue

interface IProductDataSource {
    suspend fun getProductsData(): ProductCatalogue
}