package com.deepakbarad.productcataloguecomposeapp.common.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.MainCoroutineDispatcher

@Module
@InstallIn(SingletonComponent::class)
object DispatcherModule {

    @Provides
    fun providesIoDispatcher(): CoroutineDispatcher = Dispatchers.IO
}