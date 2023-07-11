package kr.chs.feature.movielist.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptionsBuilder
import androidx.navigation.compose.composable
import kr.chs.feature.movielist.MovieListScreen

const val movieListNavigationRoute = "movie_list_route"

// movieList로 Navigate
fun NavController.navigateToMovieList(navOptions: NavOptionsBuilder.() -> Unit = {}) {
    this.navigate(movieListNavigationRoute, navOptions)
}

// NavGraph에 Composable 추가
fun NavGraphBuilder.movieListScreen() {
    composable(
        route = movieListNavigationRoute
    ) {
        MovieListScreen()
    }
}