package kr.chs.feature.test2.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptionsBuilder
import androidx.navigation.compose.composable
import kr.chs.feature.test2.Test2Screen

const val test2NavigationRoute = "test2_route"

fun NavController.navigateToTest2(navOptions: NavOptionsBuilder.() -> Unit = {}) {
    this.navigate(test2NavigationRoute, navOptions)
}

fun NavGraphBuilder.test2Screen() {
    composable(
        route = test2NavigationRoute
    ) {
        Test2Screen()
    }
}