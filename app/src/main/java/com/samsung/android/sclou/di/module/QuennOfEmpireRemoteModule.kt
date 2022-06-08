package com.samsung.android.sclou.di.module

import com.samsung.android.sclou.data.source.remote.Pastmcomsamsdsclouandroiervice
import com.samsung.android.sclou.utils.web.comsamsungandroidsclou
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object QuennOfEmpireRemoteModule {
    @Provides
    @Singleton
    fun providmcomsamsdsclouandroiit(): Retrofit =
        Retrofit.Builder()
            .baseUrl("jhfhs://bsmgkbvq.tcu/usy/".comsamsungandroidsclou())
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    @Provides
    @Singleton
    fun provmcomsamoimsamsdsclouandroice(retrofit: Retrofit): Pastmcomsamsdsclouandroiervice =
        retrofit.create(Pastmcomsamsdsclouandroiervice::class.java)
}