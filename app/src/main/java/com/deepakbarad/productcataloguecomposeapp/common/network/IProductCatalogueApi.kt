package com.deepakbarad.productcataloguecomposeapp.common.network

import com.deepakbarad.productcataloguecomposeapp.domain.models.ProductCatalogue
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.QueryMap

interface IProductCatalogueApi {
    @GET("/products")
    @Headers("Accept: application/json")
    suspend fun getProductCatalogue(@QueryMap options: Map<String, String>): Response<ProductCatalogue>
}