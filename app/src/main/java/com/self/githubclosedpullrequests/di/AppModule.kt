package com.self.githubclosedpullrequests.di

import com.self.githubclosedpullrequests.BuildConfig
import com.self.githubclosedpullrequests.feature_closed_pull_requests.data.data_source.GitHubAPIService
import com.self.githubclosedpullrequests.feature_closed_pull_requests.data.mappers.CollosedPullRequestsMapper
import com.self.githubclosedpullrequests.feature_closed_pull_requests.data.repository.GitHubRepositoryImpl
import com.self.githubclosedpullrequests.feature_closed_pull_requests.domain.repository.GitHubRepository
import com.self.githubclosedpullrequests.feature_closed_pull_requests.domain.use_case.GetClosedPullRequestsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideOkHttpClient() = if (BuildConfig.DEBUG){
        val loggingInterceptor =HttpLoggingInterceptor()
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build()
    }else{
        OkHttpClient
            .Builder()
            .build()
    }

    @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient, BASE_URL:String): Retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BASE_URL)
        .client(okHttpClient)
        .build()

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): GitHubAPIService = retrofit.create(GitHubAPIService::class.java)


    @Provides
    @Singleton
    fun provideGitHubRepoRepository(gitHubAPIService: GitHubAPIService): GitHubRepository {
        return GitHubRepositoryImpl(gitHubAPIService)
    }

    @Provides
    @Singleton
    fun provideGitHubRepoUseCase(repository: GitHubRepository): GetClosedPullRequestsUseCase {
        return GetClosedPullRequestsUseCase(repository)
    }

}