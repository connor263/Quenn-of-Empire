package com.samsung.android.sclou.di.module

import androidx.lifecycle.MutableLiveData
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Qualifier
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object QuennOfEmpireAppModule {
    @Provides
    @Singleton
    fun providemcomsamsdsclouandroieData(): MutableLiveData<MutableMap<String, Any>> =
        MutableLiveData<MutableMap<String, Any>>()
}

@Retention(AnnotationRetention.BINARY)
@Qualifier
annotation class IODispatcher