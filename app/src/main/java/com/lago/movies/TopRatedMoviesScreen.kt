package com.lago.movies

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import com.lago.home.HomeScreenBody

enum class TopRatedMoviesScreen(
    val icon: ImageVector,
    val body: @Composable ((String) -> Unit) -> Unit
) {
    Home(
        icon = Icons.Filled.MoreVert,
        body = { HomeScreenBody() }
    ),
    Detail(
        icon = Icons.Filled.MoreVert,
        body = {}
    );

    @Composable
    fun content(onScreenChange: (String) -> Unit) {
        body(onScreenChange)
    }

    companion object {
        fun fromRoute(route: String?): TopRatedMoviesScreen =
            when (route?.substringBefore("/")) {
                Home.name -> Home
                null -> Home
                else -> throw IllegalArgumentException("Route $route is not recognized.")
            }
    }
}
