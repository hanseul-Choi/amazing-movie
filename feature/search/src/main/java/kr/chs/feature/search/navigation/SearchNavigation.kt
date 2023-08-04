package kr.chs.feature.search.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptionsBuilder
import androidx.navigation.compose.composable
import kr.chs.feature.search.SearchRoute

const val searchNavigationRoute = "search_route"

fun NavController.navigateToSearch(navOptions: NavOptionsBuilder.() -> Unit = {}) {
    this.navigate(searchNavigationRoute, navOptions)
}

fun NavGraphBuilder.searchRoute() {
    composable(
        route = searchNavigationRoute
    ) {
        SearchRoute()
    }
}