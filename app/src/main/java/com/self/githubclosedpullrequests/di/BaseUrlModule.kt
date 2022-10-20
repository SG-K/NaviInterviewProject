package com.self.githubclosedpullrequests.di

import com.self.githubclosedpullrequests.core.utils.GitHubConstants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object BaseUrlModule {

    @Provides
    fun provideBaseUrl() = GitHubConstants.BASE_URL

}