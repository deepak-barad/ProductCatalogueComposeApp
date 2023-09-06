package com.deepakbarad.productcataloguecomposeapp.common.di

import com.deepakbarad.productcataloguecomposeapp.domain.datasource.IProductDataSource
import com.deepakbarad.productcataloguecomposeapp.domain.models.Product
import com.deepakbarad.productcataloguecomposeapp.domain.models.UseCases
import com.deepakbarad.productcataloguecomposeapp.domain.repository.ProductRepository
import com.deepakbarad.productcataloguecomposeapp.domain.usecases.GetProductsDataUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    fun provideUseCases(productRepository: ProductRepository): UseCases =
        UseCases(GetProductsDataUseCase(productRepository))
}