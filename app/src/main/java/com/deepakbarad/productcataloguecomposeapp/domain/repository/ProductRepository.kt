package com.deepakbarad.productcataloguecomposeapp.domain.repository

import com.deepakbarad.productcataloguecomposeapp.domain.datasource.IProductDataSource
import com.deepakbarad.productcataloguecomposeapp.domain.models.ProductCatalogue
import javax.inject.Inject

class ProductRepository @Inject constructor(
    private val remoteDataSource: IProductDataSource
) : IProductDataSource {
    override suspend fun getProductsData(): ProductCatalogue {
        return remoteDataSource.getProductsData()
    }
}