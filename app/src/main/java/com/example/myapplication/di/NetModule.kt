package com.example.myapplication.di

import com.example.myapplication.ApiService
import com.example.myapplication.BuildConfig
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
object NetModule {

    private const val BASE_URL = "https://api.themoviedb.org/3/"

    @Singleton
    @Provides
    fun providesRetrofit(okHttpClient: OkHttpClient) =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            //.addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()

    @Provides
    fun provideOkHttpClientBuilder(): OkHttpClient.Builder = OkHttpClient.Builder()

    @Provides
    fun providesApi(retrofit: Retrofit): ApiService = retrofit.create(ApiService::class.java)

    @Provides
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor = HttpLoggingInterceptor()

    @Provides
    fun providesOkHttpClient(
        okHttpClientBuilder: OkHttpClient.Builder,
        httpLoggingInterceptor: HttpLoggingInterceptor
    ): OkHttpClient {
        if (BuildConfig.DEBUG) {
            httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
            okHttpClientBuilder.addNetworkInterceptor(httpLoggingInterceptor)
        }
        return okHttpClientBuilder
            .build()
    }

}