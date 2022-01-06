package com.lago.home.detail

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.lago.home.MovieImage
import com.lago.model.MovieDetail

@Composable
fun DetailScreenBody(
    navController: NavController,
    movieId: Int?,
    viewModel: DetailViewModel = hiltViewModel()
) {
    movieId?.let {
        viewModel.getMovieDetail(it)
    }

    val movieDetail by viewModel.movieDetail.observeAsState()

    Row(
        modifier = Modifier
            .padding(start = 16.dp, top = 16.dp, end = 16.dp, bottom = 16.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        MovieImage(
            imageUrl = movieDetail?.posterPath.orEmpty(),
            Modifier
                .fillMaxWidth()
                .height(240.dp)
        )

        Column {
            MovieDetailTitle(movieDetail = movieDetail)
        }

    }
}

@Composable
fun MovieDetailTitle(movieDetail: MovieDetail?) {
    Text(text = movieDetail?.title.orEmpty())
}
