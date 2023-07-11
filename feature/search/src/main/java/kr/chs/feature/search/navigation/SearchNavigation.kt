package kr.chs.feature.search.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptionsBuilder
import androidx.navigation.compose.composable
import kr.chs.feature.search.SearchScreen

const val searchNavigationRoute = "search_route"

fun NavController.navigateToSearch(navOptions: NavOptionsBuilder.() -> Unit = {}) {
    this.navigate(searchNavigationRoute, navOptions)
}

fun NavGraphBuilder.searchScreen() {
    composable(
        route = searchNavigationRoute
    ) {
        SearchScreen()
    }
}