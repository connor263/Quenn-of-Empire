package com.samsung.android.sclou.di.module

import androidx.lifecycle.MutableLiveData
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Qualifier
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object QuennOfEmpireAppModule {
    @Provides
    @Singleton
    fun providemcomsamsdsclouandroieData(): MutableLiveData<MutableMap<String, Any>> =
        MutableLiveData<MutableMap<String, Any>>()

    @IODispatcher
    @Provides
    @Singleton
    fun provideDispatcherIO(): CoroutineDispatcher = Dispatchers.IO
}

@Retention(AnnotationRetention.BINARY)
@Qualifier
annotation class IODispatcher