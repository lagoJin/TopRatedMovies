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
import androidx.compose.ui.unit.ExperimentalUnitApi
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
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

    Column(
        modifier = Modifier
            .padding(start = 16.dp, top = 16.dp, end = 16.dp, bottom = 16.dp)
            .fillMaxWidth(),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        MovieImage(
            imageUrl = movieDetail?.posterPath.orEmpty(),
            Modifier
                .fillMaxWidth()
                .height(240.dp)
        )
        Row(
            modifier = Modifier.padding(top = 12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            MovieDetailTitle(movieDetail = movieDetail)
            MovieDetailDate(movieDetail = movieDetail)
        }
        MovieDetailOverView(movieDetail = movieDetail)
    }
}

@OptIn(ExperimentalUnitApi::class)
@Composable
fun MovieDetailTitle(movieDetail: MovieDetail?) {
    Text(
        text = movieDetail?.title.orEmpty(),
        fontSize = TextUnit(20f, TextUnitType.Sp)
    )
}

@Composable
fun MovieDetailDate(movieDetail: MovieDetail?) {
    Text(
        modifier = Modifier.padding(start = 20.dp),
        text = movieDetail?.releaseDate.orEmpty()
    )
}

@OptIn(ExperimentalUnitApi::class)
@Composable
fun MovieDetailOverView(movieDetail: MovieDetail?) {
    Text(
        modifier = Modifier.padding(top = 12.dp),
        text = movieDetail?.overview.orEmpty(),
        fontSize = TextUnit(18f, TextUnitType.Sp)
    )
}
