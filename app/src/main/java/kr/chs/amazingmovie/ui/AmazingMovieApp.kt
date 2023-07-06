package kr.chs.amazingmovie.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import kr.chs.amazingmovie.navigation.AmazingMovieNavHost
import kr.chs.amazingmovie.navigation.TopLevelDestination
import kr.chs.core.designsystem.component.AmazingMovieNavigationBar
import kr.chs.core.designsystem.component.AmazingMovieNavigationBarItem

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AmazingMovieApp() {
    val navHostController = rememberNavController()
    val backStackEntry by navHostController.currentBackStackEntryAsState()

    val snackbarHostState = remember { SnackbarHostState() }

    Scaffold(
        modifier = Modifier,
        snackbarHost = { SnackbarHost(hostState = snackbarHostState) },
        bottomBar = {
            AppBottomBar(
                destination = TopLevelDestination.values().toList(),
                onNavigateToDestination = { destination ->
                    navHostController.navigate(destination.route) {
                        popUpTo(navHostController.graph.startDestinationId) {
                            saveState = true
                            inclusive = false
                        }
                    }
                },
                currentDestination = backStackEntry?.destination
            )
        }
    ) { contentPadding ->
        Box(
            modifier = Modifier.padding(contentPadding)
        ) {
            AmazingMovieNavHost(
                modifier = Modifier.fillMaxSize(),
                navController = navHostController,
                snackBarHostState = snackbarHostState
            )
        }
    }
}

@Composable
private fun AppBottomBar(
    destination: List<TopLevelDestination>,
    onNavigateToDestination: (TopLevelDestination) -> Unit,
    currentDestination: NavDestination?,
    modifier: Modifier = Modifier,
) {
    AmazingMovieNavigationBar(
        modifier = modifier,
    ) {
        destination.forEach { destination ->
            val isSelected = currentDestination?.route == destination.route

            AmazingMovieNavigationBarItem(
                selected = isSelected,
                onClick = { onNavigateToDestination(destination) },
                unselectedIcon = destination.unselectedIcon,
                selectedIcon = destination.selectedIcon,
                labelId = destination.iconTextId,
                alwaysShowLabel = false,
            )
        }
    }
}
