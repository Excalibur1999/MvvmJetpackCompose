package com.example.navigationdemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.navigationdemo.ui.MovieDetails
import com.example.navigationdemo.ui.list.MainList
import com.example.navigationdemo.ui.theme.NavigationDemoTheme
import com.example.navigationdemo.viewModel.MovieViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val viewModel:MovieViewModel by viewModels()
    @ExperimentalFoundationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            
            val navController = rememberNavController()

            NavigationDemoTheme {
                    NavHost(navController = navController, startDestination = "trendingMovieList"){
                        composable("trendingMovieList"){
                            MainList(navController = navController,viewModel = viewModel)
                        }
                        composable("movieDetails"){
                            MovieDetails(movieItem = viewModel.clickedItem)
                        }
                    }
                   


            }
        }
    }
}

