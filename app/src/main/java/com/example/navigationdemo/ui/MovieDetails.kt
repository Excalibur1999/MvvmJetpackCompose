package com.example.navigationdemo.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.navigationdemo.model.Result
import com.example.navigationdemo.network.MovieApiClient.BASE_IMAGE_URL
import com.google.accompanist.coil.rememberCoilPainter


@Composable
fun MovieDetails(movieItem: Result) {
    Column() {
        MovieDetailsBanner(movieItem = movieItem)
        MovieDetailsText(movieItem = movieItem)
    }
}

@Composable
fun MovieDetailsBanner(movieItem: Result) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(300.dp),
    ) {
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(),
            painter = rememberCoilPainter(request = BASE_IMAGE_URL + movieItem.backdrop_path),
            contentDescription = ""
        )
    }
}

@Composable
fun MovieDetailsText(movieItem: Result) {
    Column(modifier = Modifier.padding(8.dp)) {
        movieItem.title?.let {
            Text(
                text = it, fontFamily = FontFamily.Serif,
                fontWeight = FontWeight.Normal,
                fontSize = 24.sp
            )
        }
        Text(
            text = movieItem.overview, modifier = Modifier.padding(top = 10.dp),
            fontFamily = FontFamily.Serif, fontWeight = FontWeight.Normal, fontSize = 16.sp
        )
    }
}