package com.lago.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import coil.compose.rememberImagePainter
import com.lago.model.Movie

@Composable
fun HomeScreenBody(
    navController: NavController,
    homeViewModel: HomeViewModel = viewModel()
) {
    val lazyMovieItems: LazyPagingItems<Movie> =
        homeViewModel.searchRepo().collectAsLazyPagingItems()

    LazyColumn {
        items(lazyMovieItems) { movie ->
            movie?.let {
                MovieItem(it)
            }
        }
    }
}

@Composable
fun MovieItem(movie: Movie) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {

    }
}


@Composable
fun MovieImage(
    imageUrl: String
) {
    Image(
        painter = rememberImagePainter(imageUrl),
        contentDescription = null
    )
}
