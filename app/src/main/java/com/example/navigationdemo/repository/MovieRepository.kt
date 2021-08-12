package com.example.navigationdemo.repository

import com.example.navigationdemo.model.Result
import com.example.navigationdemo.network.MovieFetchApi
import javax.inject.Inject


class MovieRepository @Inject constructor(val api:MovieFetchApi) {

    suspend fun getMovies():Resource<List<Result>> {
        return try {
            val movieList = api.fetchTrendingMovieList().results
            Resource.Success(movieList)
        } catch (e: Exception) {
            Resource.Error(e.printStackTrace().toString())

        }
    }
}