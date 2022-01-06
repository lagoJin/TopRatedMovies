package com.lago.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import coil.compose.rememberImagePainter
import com.lago.model.Movie

@Composable
fun HomeScreenBody(
    navController: NavController,
    homeViewModel: HomeViewModel = hiltViewModel()
) {

    val lazyMovieItems: LazyPagingItems<Movie> =
        homeViewModel.searchRepo().collectAsLazyPagingItems()

    LazyColumn {
        items(lazyMovieItems) { movie ->
            movie?.let {
                MovieItem(it) { movieId ->
                    navController.navigate("detail/${movieId}")
                }
            }
        }
    }
}

@Composable
fun MovieItem(
    movie: Movie,
    onclick: (Int) -> Unit
) {
    Row(
        modifier = Modifier
            .clickable {
                onclick(movie.id)
            }
            .padding(start = 16.dp, top = 16.dp, end = 16.dp, bottom = 16.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        MovieImage(
            imageUrl = movie.posterPath,
            modifier = Modifier
                .height(100.dp)
                .padding(start = 16.dp)
        )
        MovieTitle(
            text = movie.title,
            modifier = Modifier.weight(1f)
        )
    }
}


@Composable
fun MovieImage(
    imageUrl: String,
    modifier: Modifier = Modifier
) {
    Image(
        painter = rememberImagePainter("https://image.tmdb.org/t/p/w185_and_h278_bestv2$imageUrl"),
        contentDescription = null,
        modifier = modifier
    )
}

@Composable
fun MovieTitle(
    text: String,
    modifier: Modifier = Modifier
) {
    Text(
        text = text,
        modifier = modifier
            .padding(start = 20.dp)
    )
}
