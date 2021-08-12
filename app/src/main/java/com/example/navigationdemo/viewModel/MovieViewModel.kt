package com.example.navigationdemo.viewModel

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.navigationdemo.model.MovieResponse
import com.example.navigationdemo.model.Result
import com.example.navigationdemo.repository.MovieRepository
import com.example.navigationdemo.repository.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class MovieViewModel @Inject constructor(
    val repo:MovieRepository)
    :ViewModel() {
    var trendingMovies:List<Result> by mutableStateOf(listOf())
    lateinit var clickedItem: Result

    init {
        getMoviews()
    }




    fun getMoviews()= viewModelScope.launch {
       var response = repo.getMovies()
        when(response){
            is Resource.Success->{
                response.data?.let {
                    trendingMovies = it
                }
            }
            is Resource.Error ->{
                Log.d("MovieVeiwModel","Failure")
            }
        }

    }
    fun itemClicked(item:Result){
        clickedItem = item
    }


}