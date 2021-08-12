package com.example.navigationdemo

import com.example.navigationdemo.network.MovieApiClient.BASE_URL
import com.example.navigationdemo.network.MovieFetchApi
import com.example.navigationdemo.repository.MovieRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideRetrofit():MovieFetchApi{
       return Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(MoshiConverterFactory.create()).build()
            .create(MovieFetchApi::class.java)
    }

    @Provides
    @Singleton
    fun provideRepo(api:MovieFetchApi):MovieRepository{
        return MovieRepository(api)
    }
}