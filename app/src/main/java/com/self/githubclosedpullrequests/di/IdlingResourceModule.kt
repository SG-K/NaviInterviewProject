package com.self.githubclosedpullrequests.di

import com.self.githubclosedpullrequests.core.ideling_resources.ComposeOkHttp3IdlingResource
import com.self.githubclosedpullrequests.core.utils.GenralConstants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object IdlingResourceModule {

    @Singleton
    @Provides
    fun getComposeOkhttpResourceIdling(okHttpClient: OkHttpClient) : ComposeOkHttp3IdlingResource {
        return ComposeOkHttp3IdlingResource().create(GenralConstants.OKHTTP, okHttpClient)
    }

}