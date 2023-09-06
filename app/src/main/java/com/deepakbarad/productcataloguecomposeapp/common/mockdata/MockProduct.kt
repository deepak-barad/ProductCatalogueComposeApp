package com.deepakbarad.productcataloguecomposeapp.common.mockdata

import com.deepakbarad.productcataloguecomposeapp.domain.models.Product
import com.deepakbarad.productcataloguecomposeapp.domain.models.ProductCatalogue

object MockProduct {

    fun productCatalogue() = ProductCatalogue(
        products = listOf(getProduct()), total = 100
    )

    private fun getProduct(): Product {
        return Product(id = 1, title = "Test Title")
    }
}