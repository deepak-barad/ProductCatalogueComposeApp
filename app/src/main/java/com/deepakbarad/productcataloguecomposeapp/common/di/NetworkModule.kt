package com.deepakbarad.productcataloguecomposeapp.common.di

import com.deepakbarad.productcataloguecomposeapp.common.network.IProductCatalogueApi
import com.deepakbarad.productcataloguecomposeapp.common.network.RetrofitHelper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @Singleton
    @Provides
    fun provideProductCatalogueApi(): IProductCatalogueApi =
        RetrofitHelper.getInstance().create(IProductCatalogueApi::class.java)
}