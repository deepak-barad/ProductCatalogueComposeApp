package com.deepakbarad.productcataloguecomposeapp.data.remotedatasource

import com.deepakbarad.productcataloguecomposeapp.common.MOCK_DATA
import com.deepakbarad.productcataloguecomposeapp.common.network.IProductCatalogueApi
import com.deepakbarad.productcataloguecomposeapp.domain.datasource.IProductDataSource
import com.deepakbarad.productcataloguecomposeapp.domain.models.ProductCatalogue
import com.google.gson.GsonBuilder
import javax.inject.Inject

class ProductRemoteDataSource @Inject constructor(private val productCatalogueApi: IProductCatalogueApi) :
    IProductDataSource {

    override suspend fun getProductsData(): ProductCatalogue {
        val gson = GsonBuilder().create()
        val queryMap: MutableMap<String, String> = mutableMapOf()
        queryMap["McasTsid"] = "11394"
        queryMap["McasCtx"] = "4"
        val productCatalogue = productCatalogueApi.getProductCatalogue(queryMap).body()
        return productCatalogue ?: ProductCatalogue(emptyList())
        //return gson.fromJson(MOCK_DATA, ProductCatalogue::class.java)
    }
}