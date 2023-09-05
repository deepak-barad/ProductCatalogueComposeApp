package com.deepakbarad.productcataloguecomposeapp.common.di

import com.deepakbarad.productcataloguecomposeapp.data.remotedatasource.ProductRemoteDataSource
import com.deepakbarad.productcataloguecomposeapp.domain.datasource.IProductDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DataSourceModule {

    @Binds
    abstract fun bindProductDataSource(remoteDataSource: ProductRemoteDataSource): IProductDataSource
}