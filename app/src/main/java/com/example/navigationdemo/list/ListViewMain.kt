package com.example.navigationdemo.list

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import com.example.navigationdemo.model.Result
import com.example.navigationdemo.viewModel.MovieViewModel


@ExperimentalFoundationApi
@Composable
fun MainList(viewModel: MovieViewModel){
       val list = viewModel.trendingMovies
      MovieList(movieList = list,onItemClicked = {
          viewModel.itemClicked(it)
      })

}

@ExperimentalFoundationApi
@Composable
fun MovieList(
    movieList:List<Result>,
    onItemClicked:(Result)->Unit
){
    var listState = rememberLazyListState()
    LazyColumn(state = listState){
        stickyHeader {
            MainHeader()
        }
        items(movieList){item->
            ListViewItem(item,onItemClicked)
        }
    }
}


@Composable
fun MainHeader(){
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colors.background)
    ){
            Text(text = "Trending Movies",
            style = MaterialTheme.typography.h4,
            textAlign = TextAlign.Center)
    }
}