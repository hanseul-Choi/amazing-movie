package kr.chs.amazingmovie.navigation

import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.NavHostController
import kr.chs.feature.test1.navigation.test1Screen
import kr.chs.feature.test2.navigation.test2Screen

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
        startDestination = TopLevelDestination.Test1.route,
    ) {
        test1Screen()
        test2Screen()
    }
}