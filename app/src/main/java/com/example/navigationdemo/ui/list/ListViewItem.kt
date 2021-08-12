package com.example.navigationdemo.ui.list

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.navigationdemo.model.Result
import com.example.navigationdemo.network.MovieApiClient.BASE_IMAGE_URL
import com.google.accompanist.coil.rememberCoilPainter

@Composable
fun ListViewItem(navController: NavController,movieItem: Result,
                 onItemClicked:(Result)->Unit
) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .height(100.dp)
            .clickable {
                onItemClicked(movieItem)
                navController.navigate("movieDetails")
            }
            ,
        elevation = 4.dp,
        shape = RoundedCornerShape(10.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = rememberCoilPainter(request = BASE_IMAGE_URL + movieItem.backdrop_path),
                contentDescription = "",
                modifier = Modifier
                    .padding(2.dp)
                    .width(180.dp)
                    .clip(RoundedCornerShape(10.dp))


            )
            Spacer(modifier = Modifier.width(20.dp))

            Column(modifier = Modifier.fillMaxSize(),
            ) {
                movieItem.title?.let {
                    Text(text = it)
                }

                Text(text = movieItem.vote_average.toString())
            }
        }
    }
}