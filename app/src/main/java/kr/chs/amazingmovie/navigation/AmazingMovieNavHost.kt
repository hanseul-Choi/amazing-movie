package kr.chs.amazingmovie.navigation

import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.NavHostController
import kr.chs.feature.search.navigation.searchRoute
import kr.chs.feature.movielist.navigation.movieListScreen
import kr.chs.feature.favorite.navigation.favoriteScreen

@Composable
internal fun AmazingMovieNavHost(
    modifier: Modifier,
    navController: NavHostController,
    snackBarHostState: SnackbarHostState
) {
    val coroutineScope = rememberCoroutineScope()

    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = TopLevelDestination.MovieList.route,
    ) {
        searchRoute()
        movieListScreen()
        favoriteScreen()
    }
}