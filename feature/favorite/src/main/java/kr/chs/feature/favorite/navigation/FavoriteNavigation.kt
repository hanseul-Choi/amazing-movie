package kr.chs.feature.favorite.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptionsBuilder
import androidx.navigation.compose.composable
import kr.chs.feature.favorite.FavoriteScreen

const val favoriteNavigationRoute = "favorite_route"

fun NavController.navigateToFavorite(navOptions: NavOptionsBuilder.() -> Unit = {}) {
    this.navigate(favoriteNavigationRoute, navOptions)
}

fun NavGraphBuilder.favoriteScreen() {
    composable(
        route = favoriteNavigationRoute
    ) {
        FavoriteScreen()
    }
}