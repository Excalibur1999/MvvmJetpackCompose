package com.example.navigationdemo.network

import com.example.navigationdemo.model.MovieResponse
import com.example.navigationdemo.repository.Resource
import retrofit2.Response
import retrofit2.http.GET

interface MovieFetchApi {

    @GET("trending/all/day?api_key=3371fda969c9502403614335515dc78a")
    suspend fun fetchTrendingMovieList():MovieResponse
}