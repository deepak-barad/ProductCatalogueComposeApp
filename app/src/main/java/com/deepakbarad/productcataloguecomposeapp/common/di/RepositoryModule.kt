package com.deepakbarad.productcataloguecomposeapp.common.di

import com.deepakbarad.productcataloguecomposeapp.domain.datasource.IProductDataSource
import com.deepakbarad.productcataloguecomposeapp.domain.repository.ProductRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    fun provideProductRepository(dataSource: IProductDataSource): ProductRepository =
        ProductRepository(dataSource)
}