package kr.chs.feature.test1.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptionsBuilder
import androidx.navigation.compose.composable
import kr.chs.feature.test1.Test1Screen

const val test1NavigationRoute = "test1_route"

fun NavController.navigateToTest1(navOptions: NavOptionsBuilder.() -> Unit = {}) {
    this.navigate(test1NavigationRoute, navOptions)
}

fun NavGraphBuilder.test1Screen() {
    composable(
        route = test1NavigationRoute
    ) {
        Test1Screen()
    }
}